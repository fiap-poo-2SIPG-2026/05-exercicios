package exercicio02;

public class ItemPedido {

    String descricao;
    double precoUnitario;
    int quantidade;

    public ItemPedido(String descricao, double precoUnitario, int quantidade) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    double calcularSubtotal() {
        return precoUnitario * quantidade;
    }
}