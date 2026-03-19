package exercicio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[10];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("1. Cadastrar bilhete");
            System.out.println("2. Carregar bilhete");
            System.out.println("3. Passar na catraca");
            System.out.println("4. Finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> passarNaCatraca();
                case 4 -> System.out.println("Até breve!");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println("\n##############################################");
        } while(opcao != 4);

    }

    private static void passarNaCatraca() {
        BilheteUnico bilheteUnico = pesquisar();
        if(bilheteUnico != null) {
            if(!bilheteUnico.passarNaCatraca()) {
                System.out.println("Saldo insuficiente");
            }
            System.out.println("Saldo atual R$ " + bilheteUnico.saldo);
        }
    }

    private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if(index < bilhete.length) {
            System.out.print("Nome do usuário: ");
            nome = sc.next();
            System.out.print("CPF: ");
            cpf = sc.nextLong();
            System.out.print("Tipo de tarifa (estudante | professor | comum): ");
            tipoTarifa = sc.next();
            Usuario usuario = new Usuario(nome, cpf, tipoTarifa);
            bilhete[index] = new BilheteUnico(usuario);
            index++;
        }
        else {
            System.out.println("Erro ao gerar o bilhete! Procure um posto de atendimento");
        }

    }

    public static BilheteUnico pesquisar() {
        long cpf;
        System.out.print("Qual o CPF para pesquisa? ");
        cpf = sc.nextLong();

        for(int i = 0; i < index; i++) {
            if(bilhete[i].usuario.cpf == cpf) {
                return bilhete[i];
            }
        }
        System.out.println("CPF não encontrado");
        return null;
    }

    public static void carregar() {
        double valor;
        BilheteUnico bilheteEncontrado = pesquisar();
        if(bilheteEncontrado != null) {
            System.out.print("Qual o valor da recarga? ");
            valor = sc.nextDouble();
            bilheteEncontrado.carregar(valor);
        }
    }
}
