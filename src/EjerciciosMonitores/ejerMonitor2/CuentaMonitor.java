package EjerciciosMonitores.ejerMonitor2;

public class CuentaMonitor {
    private static final int LIMITE_AHORRO = 250;
    private int saldo;

    public synchronized void ahorrar(int cantidad) throws InterruptedException {
        while (saldo >= LIMITE_AHORRO) {
            wait();
        }
        saldo += cantidad;
        notifyAll();
    }

    public synchronized void gastar(int cantidad) throws InterruptedException {
        while (saldo < cantidad) {
            wait();
        }
        saldo -= cantidad;
        notifyAll();
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}
