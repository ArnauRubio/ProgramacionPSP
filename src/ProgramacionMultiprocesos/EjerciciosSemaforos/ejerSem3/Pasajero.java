package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem3;

public class Pasajero implements Runnable{
    private int idPasajero;
    private Ascensor ascensor;

    public Pasajero(int idPasajero, Ascensor ascensor) {
        this.idPasajero = idPasajero;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        try {
            ascensor.usar(idPasajero);

            Thread.sleep((long) (Math.random() * 500) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
