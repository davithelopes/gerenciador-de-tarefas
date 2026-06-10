package tarefas;

public class TarefaNormal extends Tarefa {

    public TarefaNormal(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public String getPrioridade() {
        return "NORMAL";
    }
}
