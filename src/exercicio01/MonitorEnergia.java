package exercicio01;

public class MonitorEnergia {
    double[] consumo;
    int indice;

    public MonitorEnergia(int tamanho) {
        this.consumo = new double[tamanho];
    }

    public void registrar(double valor) {
        if(indice < consumo.length) {
            consumo[indice] = valor;
            indice++;
        }
    }

    public double media() {
        /*double aux = 0;
        for(int i = 0; i < indice; i++) {
            aux += consumo[i];
        }
        return aux / indice;*/
        return media(1, indice);
    }

    public double media(int inicio, int fim) {
        double aux = 0;
        for(int i = inicio - 1; i < fim; i++) {
            aux += consumo[i];
        }
        return aux / (fim - inicio + 1);
    }

}
