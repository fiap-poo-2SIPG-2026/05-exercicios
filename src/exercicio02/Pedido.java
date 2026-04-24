package exercicio02;

public class Pedido {

    int numeroPedido;
    String data;
    ItemPedido[] itens;
    int index;

    public Pedido(int numeroPedido, String data, int capacidade) {
        this.numeroPedido = numeroPedido;
        this.data = data;
        this.index = 0;
        this.itens = new ItemPedido[capacidade];
    }

    public void adicionarItem(ItemPedido item) {
        itens[index++] = item;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < index; i++) {
            if (itens[i] != null) {
                total += itens[i].calcularSubtotal();
            }
        }
        return total;
    }

    public int calcularQuantidadeTotalItens() {
        int total = 0;
        for (int i = 0; i < index; i++) {
            if (itens[i] != null) {
                total += itens[i].quantidade;
            }
        }
        return total;
    }

    public ItemPedido itemMaiorPrecoUnitario() {
        ItemPedido maior = null;
        for (int i = 0; i < index; i++) {
            if (maior == null || itens[i].precoUnitario > maior.precoUnitario) {
                maior = itens[i];
            }
        }
        return maior;
    }
}