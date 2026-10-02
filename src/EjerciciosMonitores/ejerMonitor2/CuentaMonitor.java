package EjerciciosMonitores.ejerMonitor2;

public class CuentaMonitor {
    private static int limiteAhorro = 250;
    private int saldo;

    public synchronized void ahorrar(int cantidad) throws InterruptedException {
        while (saldo >= limiteAhorro) {
            wait();
        }
        saldo += cantidad;
        System.out.println("El saldo actual es: " + saldo);
        notifyAll();
    }

    public synchronized void gastar(int cantidad) throws InterruptedException {
        while (saldo < cantidad) {
            wait();
        }
        saldo -= cantidad;
        System.out.println("El saldo actual es: " + saldo);

        notifyAll();
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}
