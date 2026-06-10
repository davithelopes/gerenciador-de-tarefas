package tarefas;

public class TarefaUrgente extends Tarefa {

    public TarefaUrgente(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public String getPrioridade() {
        return "URGENTE";
    }
}
