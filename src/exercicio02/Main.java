package exercicio02;

import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // gerando 5 itens de pedido
        ItemPedido item1 = new ItemPedido("Teclado Mecânico", 350.00, 1);
        ItemPedido item2 = new ItemPedido("Mouse Gamer", 180.00, 2);
        ItemPedido item3 = new ItemPedido("Monitor Full HD", 1200.00, 1);
        ItemPedido item4 = new ItemPedido("Cabo HDMI", 45.00, 3);
        ItemPedido item5 = new ItemPedido("Headset USB", 270.00, 1);

        // montagem do pedido 1
        Pedido pedido1 = new Pedido(1001, "20/04/2025", 3);
        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        pedido1.adicionarItem(item3);

        // montagem do pedido 2
        Pedido pedido2 = new Pedido(1002, "23/04/2025", 2);
        pedido2.adicionarItem(item4);
        pedido2.adicionarItem(item5);

        // gerando o cliente
        Cliente cliente = new Cliente("Ana Maria Braga", "123.456.789-00", 2);
        cliente.adicionarPedido(pedido1);
        cliente.adicionarPedido(pedido2);

        // relatórios
        System.out.println("========================================");
        System.out.println("         RELATÓRIO DO CLIENTE           ");
        System.out.println("========================================");
        System.out.println("Nome : " + cliente.nome);
        System.out.println("CPF  : " + cliente.cpf);
        System.out.println("Total gasto em todos os pedidos: R$ " + df.format(cliente.calcularTotalGasto()));

        Pedido maiorPedido = cliente.pedidoDeMaiorValor();
        System.out.println("Pedido de maior valor: #" + maiorPedido.numeroPedido
                + " (R$ " + df.format(maiorPedido.calcularValorTotal()) + ")");

        for (int i = 0; i < cliente.index; i++) {
            Pedido p = cliente.pedidos[i];
            if (p != null) {
                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("Pedido #" + p.numeroPedido + " - Data: " + p.data);
                System.out.println("----------------------------------------");
                System.out.println("Itens:");
                for (int j = 0; j < p.index; j++) {
                    ItemPedido it = p.itens[j];
                    if (it != null) {
                        System.out.println("  - " + it.descricao
                                + " | Qtd: " + it.quantidade
                                + " | Preço unit.: R$ " + df.format(it.precoUnitario)
                                + " | Subtotal: R$ " + df.format(it.calcularSubtotal()));
                    }
                }
                System.out.println("Quantidade total de itens comprados : " + p.calcularQuantidadeTotalItens());
                System.out.println("Valor total do pedido               : R$ " + df.format(p.calcularValorTotal()));

                ItemPedido maisCaroItem = p.itemMaiorPrecoUnitario();
                System.out.println("Item com maior preço unitário       : " + maisCaroItem.descricao
                        + " (R$ " + df.format(maisCaroItem.precoUnitario) + ")");
            }
        }

        System.out.println("========================================");
    }
}