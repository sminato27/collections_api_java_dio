package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private String palavra;          // Declaração de variável de instância para uma palavra (não utilizada no código fornecido)
    private Set<String> palavrasSet; // Declaração de um conjunto (Set) de Strings para armazenar palavras únicas

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();  // Construtor que inicializa o HashSet que armazenará as palavras únicas
    }

    public void addPalavra(String palavra) {
        palavrasSet.add(palavra);   // Método para adicionar uma palavra ao conjunto de palavras únicas
    }

    public void removerPalavra(String palavra) {
        String palavraRemover = null;
        // Método para remover uma palavra do conjunto, ignorando diferenciação de maiúsculas/minúsculas
        for (String p : palavrasSet) {
            if (p.equalsIgnoreCase(palavra)) {
                palavraRemover = p;  // Encontra a palavra a ser removida
                break;
            }
        }
        palavrasSet.remove(palavraRemover);  // Remove a palavra do conjunto
    }

    // Método para verificar se uma palavra está presente no conjunto
    public void verificarPalavra(String palavra) {
        boolean encontrada = false;   // Flag para indicar se a palavra foi encontrada
        // Percorre o conjunto para verificar se a palavra está presente (ignorando maiúsculas/minúsculas)
        for (String p : palavrasSet) {
            if (p.equalsIgnoreCase(palavra)) {
                encontrada = true;  // Define a flag como true se a palavra for encontrada
                break;
            }
        }
        // Exibe uma mensagem indicando se a palavra foi encontrada ou não
        if (encontrada){
            System.out.println("Palavra '" + palavra + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavra + "' não encontrada.");
        }
    }

    // Método para exibir todas as palavras únicas presentes no conjunto
    public void exibirPalavrasUnicas() {
        System.out.println("Palavras únicas:");
        // Percorre o conjunto para exibir cada palavra única
        for (String palavras : palavrasSet) {
            System.out.println(palavras);
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        // Adiciona algumas palavras ao conjunto
        conjuntoPalavrasUnicas.addPalavra("abelha");
        conjuntoPalavrasUnicas.addPalavra("mel");
        conjuntoPalavrasUnicas.addPalavra("mel");   // 'mel' já existe, não será adicionado novamente
        conjuntoPalavrasUnicas.addPalavra("cadeira");
        conjuntoPalavrasUnicas.addPalavra("plágio");

        // Exibe as palavras únicas presentes no conjunto
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // Remove a palavra "mel" do conjunto
        conjuntoPalavrasUnicas.removerPalavra("mel");

        // Exibe novamente as palavras únicas após a remoção
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // Verifica se algumas palavras específicas estão presentes no conjunto
        conjuntoPalavrasUnicas.verificarPalavra("elefante");
        conjuntoPalavrasUnicas.verificarPalavra("plágio");
    }
}
