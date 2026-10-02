package EjerciciosMonitores.ejerMonitor1;

public class Mesas {
    private int mesasDisponibles;

    public Mesas(int mesasDisponibles) {
        if (mesasDisponibles <= 0) {
            throw new IllegalArgumentException("Debe haber al menos una mesa");
        }
        this.mesasDisponibles = mesasDisponibles;
    }

    public synchronized int getMesasDisponibles() {
        return mesasDisponibles;
    }

    public synchronized void entrar(int idCliente) throws InterruptedException {
        while (mesasDisponibles == 0) {
            System.out.println("Cliente " + idCliente + " espera por una mesa");
            wait();
        }
        mesasDisponibles--;
        System.out.println("Cliente " + idCliente + " ocupa una mesa. Mesas disponibles: " + mesasDisponibles);
    }

    public synchronized void salir(int idCliente) {
        mesasDisponibles++;
        System.out.println("Cliente " + idCliente + " libera una mesa. Mesas disponibles: " + mesasDisponibles);
        notifyAll();
    }
}
