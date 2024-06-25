package list.Ordenacao;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void addNumero(int numero) {
        this.numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAsc = new ArrayList<>(numeros);
        Collections.sort(numerosAsc);
        return numerosAsc;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDesc = new ArrayList<>(numeros);
        Collections.sort(numerosDesc, Collections.reverseOrder());
        return numerosDesc;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.addNumero(4);
        ordenacaoNumeros.addNumero(2);
        ordenacaoNumeros.addNumero(66);
        ordenacaoNumeros.addNumero(32);
        ordenacaoNumeros.addNumero(493);
        ordenacaoNumeros.addNumero(55);
        ordenacaoNumeros.addNumero(17);

        System.out.println(ordenacaoNumeros.numeros);

        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());

    }
}
