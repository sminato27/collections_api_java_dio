package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void addNumero(int numero) {
        this.numeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
            for (Integer numero : numeros) {
                soma += numero;
            }
        return soma;
    }

    public int maiorNum() {
        int maior = Integer.MIN_VALUE;
        if (!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                if (numero >= maior) {
                    maior = numero;
                }
            }
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
        return maior;
    }

    public int menorNum() {
        int menor = Integer.MAX_VALUE;
        if (!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                if (numero <= menor) {
                    menor = numero;
                }
            }
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
        return menor;
    }

    public void exibirNumeros() {
        if (!numeros.isEmpty()) {
            System.out.println(this.numeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
     SomaNumeros somaNumeros = new SomaNumeros();

     somaNumeros.addNumero(5);
     somaNumeros.addNumero(13);
     somaNumeros.addNumero(2);
     somaNumeros.addNumero(64);

        System.out.println("Números adicionados: ");
        somaNumeros.exibirNumeros();

        System.out.println("A soma dos números é: " + somaNumeros.calcularSoma());

        System.out.println("O maior número é: " + somaNumeros.maiorNum());

        System.out.println("O menor número é: " + somaNumeros.menorNum());
    }
}
