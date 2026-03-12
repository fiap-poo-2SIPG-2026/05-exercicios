package exercicio01;

public class Main {
    public static void main(String[] args) {
        MonitorEnergia monitor = new MonitorEnergia(200);
        monitor.registrar(3);
        monitor.registrar(1);
        monitor.registrar(2);
        monitor.registrar(3);
        monitor.registrar(2);

        System.out.println("Média dos consumos registrados: " + monitor.media());
        System.out.println("Média de consumo no intervalo: " + monitor.media(2, 4));
    }
}
