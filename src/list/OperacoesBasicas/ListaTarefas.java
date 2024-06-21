package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    // Atributo:
    private List<Tarefa> tarefaList;

    // Construtor:
    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    // Método para adicionar uma nova tarefa:
    public void addTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    // Método para remover uma tarefa:
    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa f : tarefaList) {
            if (f.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(f);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
    }

    // Método para contar quantas tarefas estão inseridas no ListaTarefas:
    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    // Método para mostrar todas as tarefas inseridas no ListaTarefas:
    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }


    public static void main(String[] args) {
        // Criando uma nova caixa de tarefas:
        ListaTarefas listaTarefa  = new ListaTarefas();


        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.addTarefa("Tarefa 1");
        listaTarefa.addTarefa("Tarefa 2");
        listaTarefa.addTarefa("Tarefa 2");

        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());


        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }
}
