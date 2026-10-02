package EjerciciosMonitores.ejerMonitor2;

public class AccionesCuenta implements Runnable {
    private static final int cantidad = 10;
    private static final int operaciones = 100;

    private final CuentaMonitor cuenta;
    private final boolean ahorrador;

    public AccionesCuenta(CuentaMonitor cuenta, boolean ahorrador) {
        this.cuenta = cuenta;
        this.ahorrador = ahorrador;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < operaciones; i++) {
                if (ahorrador) {
                    cuenta.ahorrar(cantidad);
                } else {
                    cuenta.gastar(cantidad);
                }
            }
            System.out.println(Thread.currentThread().getName() + " ha terminado");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
