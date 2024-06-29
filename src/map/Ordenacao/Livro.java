package map.Ordenacao;

import java.util.Comparator;
import java.util.Map;

// Classe que representa um Livro com título, autor e preço
public class Livro {
    private String titulo;
    private String autor;
    private double preco;

    // Construtor para inicializar um Livro com título, autor e preço
    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    // Método para retornar o título do Livro
    public String getTitulo() {
        return titulo;
    }

    // Método para retornar o autor do Livro
    public String getAutor() {
        return autor;
    }

    // Método para retornar o preço do Livro
    public double getPreco() {
        return preco;
    }

    // Método toString para representar o Livro em formato de String
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }
}

// Classe ComparatorPorPreco que compara Livros por seu preço
class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        // Compara os preços dos Livros usando Double.compare para lidar com precisão de ponto flutuante
        return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
    }
}

// Classe ComparatorPorAutor que compara Livros por seu autor, ignorando maiúsculas/minúsculas
class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        // Compara os autores dos Livros ignorando maiúsculas/minúsculas
        return l1.getValue().getAutor().compareToIgnoreCase(l2.getValue().getAutor());
    }
}
