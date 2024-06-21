package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    // Atributo:
    private List<Item> itemList;

    // Construtor:
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item i : itemList) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        itemList.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double total = 0.0;

        for (Item i : itemList) {
            total += i.getPreco() * i.getQuantidade();
        }
        return total;
    }

    public String exibirItens() {
        return itemList.toString();
    }

    public static void main(String[] args) {
         CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

         carrinhoDeCompras.addItem("Chocolate", 4.55, 2);
         carrinhoDeCompras.addItem("Leite", 5, 10);
         carrinhoDeCompras.addItem("Arroz", 10, 1);
         carrinhoDeCompras.addItem("Chocolate", 4.55, 5);

        System.out.println("Estes são os itens que você tem no carrinho: " + carrinhoDeCompras.exibirItens());

        System.out.println("O valor total dos itens em seu carrinho é: R$" + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Chocolate");

        System.out.println("Estes são os itens que você tem no carrinho: " + carrinhoDeCompras.exibirItens());
        System.out.println("O valor total dos itens em seu carrinho é: R$" + carrinhoDeCompras.calcularValorTotal());
    }















}
