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
}
