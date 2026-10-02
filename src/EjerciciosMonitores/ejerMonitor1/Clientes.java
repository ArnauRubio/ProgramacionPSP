package EjerciciosMonitores.ejerMonitor1;

public class Clientes implements Runnable{
    private final int idCliente;
    private final Mesas mesas;

    public Clientes(int idCliente, Mesas mesas) {
        this.idCliente = idCliente;
        this.mesas = mesas;
    }

    @Override
    public void run() {
        boolean sentado = false;
        try {
            mesas.entrar(idCliente);
            sentado = true;
            Thread.sleep((long) (Math.random() * 4000) + 1000);
            System.out.println("Cliente " + idCliente + " termina de comer");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (sentado) {
                mesas.salir(idCliente);
            }
        }
    }
}
