package set.OperacoesBasicas;

import java.util.Objects;

// Definição da classe Convidado
public class Convidado {
    // Atributos privados da classe
    private String nome;
    private int codigoConvite;

    // Construtor da classe Convidado
    public Convidado(String nome, int codigoConvite) {
        this.nome = nome;  // Inicializa o nome do convidado
        this.codigoConvite = codigoConvite;  // Inicializa o código do convite do convidado
    }

    // Método para obter o nome do convidado
    public String getNome() {
        return nome;
    }

    // Método para obter o código do convite do convidado
    public int getCodigoConvite() {
        return codigoConvite;
    }

    // Método equals sobrescrito para comparar objetos Convidado
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Verifica se é a mesma referência de objeto
        if (o == null || getClass() != o.getClass()) return false;  // Verifica se o objeto é nulo ou não pertence à mesma classe
        Convidado convidado = (Convidado) o;  // Faz o cast do objeto para Convidado
        return getCodigoConvite() == convidado.getCodigoConvite();  // Compara os códigos de convite
    }

    // Método hashCode sobrescrito para calcular o hash do objeto
    @Override
    public int hashCode() {
        return Objects.hashCode(getCodigoConvite());  // Usa o hashCode de Objects para gerar o hash baseado no código de convite
    }

    // Método toString sobrescrito para representação textual do objeto
    @Override
    public String toString() {
        return "Convidado{" +
                "nome='" + nome + '\'' +
                ", codigoConvite=" + codigoConvite +
                '}';
    }
}

/*
Método equals sobrescrito: Este método compara dois objetos Convidado para verificar se são iguais.
Ele retorna true se o objeto passado como argumento for do tipo Convidado e tiver o mesmo código de convite que o objeto atual.

Método hashCode sobrescrito: Este método calcula um código hash para o objeto Convidado, baseado apenas no código de convite.
Isso é importante para que objetos iguais (segundo o método equals) tenham o mesmo código hash, garantindo consistência em estruturas de dados que dependem de hash, como HashSet.

'equals' e 'hashCode' foram implementados para suportar corretamente a comparação e o armazenamento de objetos Convidado
em coleções que dependem de chaves únicas (como HashSet e HashMap).
O método equals garante que dois objetos Convidado com o mesmo código de convite sejam considerados iguais.
O método hashCode assegura que objetos iguais produzam o mesmo valor de hash, otimizando a busca e a inserção em estruturas de dados baseadas em hash.
 */
