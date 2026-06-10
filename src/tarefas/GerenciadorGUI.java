package tarefas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GerenciadorGUI extends JFrame {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> listaTarefas = new JList<>(listModel);
    private JTextField campoTitulo = new JTextField(20);
    private JTextField campoDescricao = new JTextField(20);
    private JComboBox<String> comboPrioridade = new JComboBox<>(new String[]{"NORMAL", "URGENTE"});

    public GerenciadorGUI() {
        setTitle("Gerenciador de Tarefas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        painelEntrada.add(new JLabel("Título:"));
        painelEntrada.add(campoTitulo);
        painelEntrada.add(new JLabel("Descrição:"));
        painelEntrada.add(campoDescricao);
        painelEntrada.add(new JLabel("Prioridade:"));
        painelEntrada.add(comboPrioridade);

        JButton btnAdicionar = new JButton("Adicionar Tarefa");
        btnAdicionar.addActionListener(e -> adicionarTarefa());
        painelEntrada.add(btnAdicionar);

        JButton btnConcluir = new JButton("Concluir Tarefa");
        btnConcluir.addActionListener(e -> concluirTarefa());
        painelEntrada.add(btnConcluir);

        add(painelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(listaTarefas), BorderLayout.CENTER);

        setVisible(true);
    }

    private void adicionarTarefa() {
        try {
            String titulo = campoTitulo.getText().trim();
            String descricao = campoDescricao.getText().trim();

            if (titulo.isEmpty()) {
                throw new IllegalArgumentException("O título não pode ser vazio!");
            }

            Tarefa tarefa;
            if (comboPrioridade.getSelectedItem().equals("URGENTE")) {
                tarefa = new TarefaUrgente(titulo, descricao);
            } else {
                tarefa = new TarefaNormal(titulo, descricao);
            }

            tarefas.add(tarefa);
            listModel.addElement(tarefa.toString());
            campoTitulo.setText("");
            campoDescricao.setText("");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void concluirTarefa() {
        try {
            int index = listaTarefas.getSelectedIndex();
            if (index == -1) {
                throw new IllegalStateException("Selecione uma tarefa para concluir!");
            }
            tarefas.get(index).setConcluida(true);
            listModel.set(index, tarefas.get(index).toString());

        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GerenciadorGUI();
    }
}
