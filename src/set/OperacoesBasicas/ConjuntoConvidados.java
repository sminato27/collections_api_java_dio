package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

// Definição da classe ConjuntoConvidados
public class ConjuntoConvidados {
    // Declaração do conjunto de convidados usando Set, que garante elementos únicos
    private Set<Convidado> convidadoSet;

    // Construtor da classe
    public ConjuntoConvidados() {
        // Inicializa o conjunto como um HashSet, que oferece tempo constante para operações básicas
        this.convidadoSet = new HashSet<>();
    }

    // Método para adicionar um convidado ao conjunto
    public void addConvidado(String nome, int codigoConvite) {
        // Cria um novo objeto Convidado com os parâmetros fornecidos
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    // Método para remover um convidado com base no código do convite
    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        // Variável para armazenar o convidado a ser removido, inicialmente nula
        Convidado convidadoRemover = null;

        // Percorre todos os convidados no conjunto
        for (Convidado c : convidadoSet) {
            // Verifica se o código do convite do convidado atual é igual ao fornecido
            if (c.getCodigoConvite() == codigoConvite) {
                // Se encontrar o convidado com o código de convite correspondente, armazena-o
                convidadoRemover = c;
                break;  // Interrompe o loop, pois encontrou o convidado
            }
        }

        // Remove o convidado do conjunto (se encontrado)
        convidadoSet.remove(convidadoRemover);
    }

    // Método para contar o número de convidados no conjunto
    public int contarConvidados() {
        return convidadoSet.size();  // Retorna o tamanho do conjunto
    }

    // Método para exibir todos os convidados presentes no conjunto
    public void exibirConvidados() {
        System.out.println(convidadoSet);  // Imprime o conjunto de convidados
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.addConvidado("Iara", 1234);
        conjuntoConvidados.addConvidado("Galadriel", 1235);
        conjuntoConvidados.addConvidado("Samuel", 1235);
        conjuntoConvidados.addConvidado("Heitor", 1236);

        // O convidado 3 cujo código de convite é o mesmo que do convidado 2 não entra na lista.
        conjuntoConvidados.exibirConvidados();

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");


        conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

    }
}

/*
HashSet foi escolhido como a implementação de Set para convidadoSet porque oferece tempo constante para operações básicas
como adição, remoção e verificação de existência. Isso é ideal para garantir que cada convidado seja único no conjunto.

O construtor inicializa convidadoSet como um HashSet vazio. Isso prepara o objeto ConjuntoConvidados com uma estrutura de dados pronta para armazenar objetos Convidado.

addConvidado permite adicionar um novo Convidado ao conjunto. Ele cria um novo objeto Convidado com os parâmetros fornecidos e o adiciona ao convidadoSet.

removerConvidadoPorCodigoConvite remove um convidado do conjunto com base no código de convite fornecido.
Ele percorre o conjunto para encontrar o convidado com o código de convite correspondente e o remove.

contarConvidados retorna o número de convidados atualmente no conjunto, utilizando o método size() de HashSet.

exibirConvidados imprime todos os convidados presentes no conjunto utilizando o método toString() padrão de HashSet.
 */