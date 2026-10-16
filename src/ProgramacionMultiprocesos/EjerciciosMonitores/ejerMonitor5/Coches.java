package ProgramacionMultiprocesos.EjerciciosMonitores.ejerMonitor5;

public class Coches implements Runnable {
    private int idVehiculo;
    private int peso;
    private Puente puente;

    public Coches(int idVehiculo, int peso, Puente puente) {
        if (puente == null) {
            throw new IllegalArgumentException("El puente no puede ser nulo");
        }
        this.idVehiculo = idVehiculo;
        this.peso = peso;
        this.puente = puente;
    }

    @Override
    public void run() {
        boolean enPuente = false;
        try {
            enPuente = puente.entrar(idVehiculo, peso);
            if (enPuente) {
                Thread.sleep((long) (Math.random() * 1500) + 500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (enPuente) {
                puente.salir(idVehiculo, peso);
            }
        }
    }
}
