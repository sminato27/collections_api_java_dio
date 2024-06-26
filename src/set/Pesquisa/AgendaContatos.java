package set.Pesquisa;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void addContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContato() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContato();

        agendaContatos.addContato("Guilherme", 12345);
        agendaContatos.addContato("Guilherme", 0);
        agendaContatos.addContato("Guilherme Paim", 11111);
        agendaContatos.addContato("Guilherme Augusto", 67890);
        agendaContatos.addContato("Jordana", 11111);

        agendaContatos.exibirContato();

        System.out.println(agendaContatos.pesquisarPorNome("Guilherme"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Jordana", 99913));

        agendaContatos.exibirContato();

    }
}
