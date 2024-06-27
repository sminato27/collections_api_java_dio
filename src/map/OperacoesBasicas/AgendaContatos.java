package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void addContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone); // O método Put dá replace no valor invés de adicionar um novo com o novo valor.
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.addContato("Guilherme", 12345);
        agendaContatos.addContato("Guilherme", 0);
        agendaContatos.addContato("Guilherme Paim", 11111);
        agendaContatos.addContato("Guilherme Augusto", 67890);
        agendaContatos.addContato("Jordana", 11111);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Guilherme Augusto");

        agendaContatos.exibirContatos();

        System.out.println("O número é: " + agendaContatos.pesquisarPorNome("Guilherme Paim"));
    }
}