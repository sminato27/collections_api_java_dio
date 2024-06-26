package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;  // Conjunto para armazenar as tarefas

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();  // Inicializa o conjunto como HashSet ao criar uma nova lista de tarefas
    }

    // Método para adicionar uma nova tarefa à lista
    public void addTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao, false);  // Cria uma nova tarefa com a descrição fornecida e inicialmente não concluída
        tarefaSet.add(tarefa);  // Adiciona a tarefa ao conjunto
    }

    // Método para remover uma tarefa da lista baseada na descrição
    public void removerTarefa(String descricao) {
        Tarefa tarefaRemover = null;
        // Percorre todas as tarefas no conjunto
        for (Tarefa t : tarefaSet) {
            // Compara a descrição da tarefa ignorando maiúsculas/minúsculas
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaRemover = t;  // Armazena a tarefa a ser removida
                break;  // Para a iteração após encontrar a primeira correspondência
            }
        }
        if (tarefaRemover != null) {
            tarefaSet.remove(tarefaRemover);  // Remove a tarefa do conjunto se encontrada
        }
    }

    // Método para exibir todas as tarefas presentes no conjunto
    public void exibirTarefas() {
        System.out.println(tarefaSet);  // Imprime o conjunto de tarefas
    }

    // Método para contar o número total de tarefas na lista
    public int contarTarefa() {
        return tarefaSet.size();  // Retorna o tamanho do conjunto, que é o número de tarefas
    }

    // Método para exibir todas as tarefas concluídas
    public void obterTarefasConcluidas() {
        System.out.println("Tarefas concluídas:");
        // Percorre todas as tarefas no conjunto
        for (Tarefa t : tarefaSet) {
            // Verifica se a tarefa está concluída
            if (t.isConcluida()) {
                System.out.println(t);  // Imprime a tarefa se estiver concluída
            }
        }
    }

    // Método para obter um conjunto de tarefas pendentes
    public Set<Tarefa> obterTarefasPendentes() {
        System.out.println("Tarefas pendentes:");
        Set<Tarefa> tarefasPendentes = new HashSet<>();  // Cria um novo conjunto para armazenar tarefas pendentes
        // Percorre todas as tarefas no conjunto
        for (Tarefa t : tarefaSet) {
            // Verifica se a tarefa não está concluída
            if (!t.isConcluida()) {
                tarefasPendentes.add(t);  // Adiciona a tarefa ao conjunto de tarefas pendentes
            }
        }
        return tarefasPendentes;  // Retorna o conjunto de tarefas pendentes
    }

    // Método para marcar uma tarefa como concluída baseada na descrição
    public void marcarTarefaConcluida(String descricao) {
        // Percorre todas as tarefas no conjunto
        for (Tarefa t : tarefaSet) {
            // Compara a descrição da tarefa ignorando maiúsculas/minúsculas
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);  // Marca a tarefa como concluída
                System.out.println("Tarefa marcada como concluída: " + descricao);
                return;  // Sai do método após marcar a tarefa
            }
        }
        System.out.println("Tarefa não encontrada: " + descricao);
    }

    // Método para marcar uma tarefa como pendente baseada na descrição
    public void marcarTarefaPendente(String descricao) {
        // Percorre todas as tarefas no conjunto
        for (Tarefa t : tarefaSet) {
            // Compara a descrição da tarefa ignorando maiúsculas/minúsculas
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(false);  // Marca a tarefa como pendente (não concluída)
                System.out.println("Tarefa marcada como pendente: " + descricao);
                return;  // Sai do método após marcar a tarefa
            }
        }
        System.out.println("Tarefa não encontrada: " + descricao);
    }

    // Método para limpar a lista de tarefas, removendo todas as tarefas do conjunto
    public void limparListaTarefas() {
        tarefaSet.clear();  // Limpa o conjunto de tarefas
        System.out.println("Lista de tarefas foi limpa.");
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.addTarefa("Fazer compras");
        listaTarefas.addTarefa("Estudar para a prova");
        listaTarefas.addTarefa("Lavar o carro");

        System.out.println("Todas as tarefas:");
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaConcluida("Fazer compras");

        listaTarefas.obterTarefasConcluidas();

        Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();
        System.out.println("Tarefas pendentes:");
        for (Tarefa tarefa : tarefasPendentes) {
            System.out.println(tarefa);
        }

        listaTarefas.marcarTarefaPendente("Estudar para a prova");

        System.out.println("Todas as tarefas após marcar como pendente:");
        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Lavar o carro");

        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();

        listaTarefas.exibirTarefas();
    }
}
