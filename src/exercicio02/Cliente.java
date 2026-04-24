package exercicio02;

public class Cliente {

    String nome;
    String cpf;
    Pedido[] pedidos;
    int index;

    public Cliente(String nome, String cpf, int capacidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.index = 0;
        this.pedidos = new Pedido[capacidade];
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos[index++] = pedido;
    }

    public double calcularTotalGasto() {
        double total = 0;
        for (int i = 0; i < index; i++) {
            if (pedidos[i] != null) {
                total += pedidos[i].calcularValorTotal();
            }
        }
        return total;
    }

    public Pedido pedidoDeMaiorValor() {
        Pedido maior = null;
        for (int i = 0; i < index; i++) {
            if (maior == null || pedidos[i].calcularValorTotal() > maior.calcularValorTotal()) {
                maior = pedidos[i];
            }
        }
        return maior;
    }
}