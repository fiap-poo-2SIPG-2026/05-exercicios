package exercicio03;

import java.util.Random;

public class BilheteUnico {
    int numero;
    double saldo;
    final static double TARIFA = 5.40;
    Usuario usuario;

    public BilheteUnico(Usuario usuario) {
        Random random = new Random();
        this.numero = random.nextInt(1000, 9999);
        this.usuario = usuario;
    }

    public void carregar(double valor) {
        saldo += valor;
    }

    public boolean passarNaCatraca() {
        double valor = TARIFA / 2;
        if(usuario.tipoTarifa.equalsIgnoreCase("comum")) {
            valor = TARIFA;
        }
        if(saldo < valor) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
