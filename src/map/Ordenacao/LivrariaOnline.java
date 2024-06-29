package map.Ordenacao;

import java.util.HashMap;
import java.util.*;


public class LivrariaOnline {
    private Map<String, Livro> livros;

    // Construtor que inicializa o mapa de livros
    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    // Método para adicionar um livro à livraria
    public void adicionarLivro(String link, Livro livro) {
        livros.put(link, livro); // Insere o livro no mapa usando o link como chave
    }

    // Método para remover um livro da livraria pelo título
    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>(); // Lista para armazenar as chaves a serem removidas
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) { // Compara ignorando maiúsculas/minúsculas
                chavesRemover.add(entry.getKey()); // Adiciona a chave do livro que corresponde ao título
            }
        }
        for (String chave : chavesRemover) {
            livros.remove(chave); // Remove todas as chaves encontradas na lista
        }
    }

    // Método para exibir os livros ordenados por preço
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco()); // Ordena usando um Comparator customizado

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>(); // Mantém a ordem de inserção

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue()); // Insere no mapa ordenado
        }

        return livrosOrdenadosPorPreco; // Retorna o mapa ordenado por preço
    }

    // Método para exibir os livros ordenados por autor
    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor()); // Ordena usando um Comparator customizado

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>(); // Mantém a ordem de inserção

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue()); // Insere no mapa ordenado
        }

        return livrosOrdenadosPorAutor; // Retorna o mapa ordenado por autor
    }

    // Método para pesquisar livros por autor
    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>(); // Mantém a ordem de inserção
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)) { // Verifica se o autor do livro corresponde ao autor fornecido
                livrosPorAutor.put(entry.getKey(), livro); // Adiciona ao mapa de livros por autor
            }
        }
        return livrosPorAutor; // Retorna o mapa de livros do autor especificado
    }

    // Método para obter o(s) livro(s) mais caro(s)
    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE; // Inicializa com o menor valor possível de double

        if (!livros.isEmpty()) { // Verifica se a livraria não está vazia
            for (Livro livro : livros.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco(); // Atualiza o preço mais alto encontrado
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!"); // Lança exceção se a livraria estiver vazia
        }

        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livros.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto); // Adiciona o(s) livro(s) com o preço mais alto à lista
            }
        }
        return livrosMaisCaros; // Retorna a lista de livros mais caros
    }

    // Método para obter o(s) livro(s) mais barato(s)
    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE; // Inicializa com o maior valor possível de double

        if (!livros.isEmpty()) { // Verifica se a livraria não está vazia
            for (Livro livro : livros.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco(); // Atualiza o preço mais baixo encontrado
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!"); // Lança exceção se a livraria estiver vazia
        }

        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo = livros.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo); // Adiciona o(s) livro(s) com o preço mais baixo à lista
            }
        }
        return livrosMaisBaratos; // Retorna a lista de livros mais baratos
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livros);

    }
}
