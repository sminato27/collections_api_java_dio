package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    // Construtor da classe, inicializa o mapa palavras como um HashMap
    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    // Método para adicionar uma palavra e sua contagem ao mapa
    public void adicionarPalavras(String linguagem, Integer contagem) {
        palavras.put(linguagem, contagem);
    }

    // Método para remover uma palavra do mapa
    public void removerPalavra(String palavra) {
        if (!palavras.isEmpty()) {
            palavras.remove(palavra);
        } else {
            System.out.println("O Map está vazio.");
        }
    }

    // Método para exibir a contagem total de palavras no mapa
    public int exibirContagemPalavras() {
        int contagemTotal = 0;
        // Itera sobre os valores (contagens) no mapa e soma ao contador total
        for (int contagem : palavras.values()) {
            contagemTotal += contagem;
        }
        return contagemTotal;
    }

    // Método para encontrar a palavra mais frequente (com maior contagem)
    public String encontrarPalavrasMaisFrequente() {
        String linguagemMaisFrequente = null;
        int maiorContagem = 0;
        // Itera sobre as entradas do mapa (palavra, contagem)
        for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
            // Compara a contagem atual com a maior contagem encontrada até agora
            if (entry.getValue() > maiorContagem) {
                // Atualiza a maior contagem e a palavra mais frequente
                maiorContagem = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        // Retorna a palavra mais frequente (ou null se o mapa estiver vazio)
        return linguagemMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavrasMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
