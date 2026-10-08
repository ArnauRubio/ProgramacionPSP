package EjerciciosMonitores.ejerMonitor4;

public class Limpieza implements Runnable {
    private final Pista pista;
    private final long duracion;

    public Limpieza(Pista pista, long duracion) {
        if (pista == null) {
            throw new IllegalArgumentException("La pista no puede ser nula");
        }
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa");
        }
        this.pista = pista;
        this.duracion = duracion;
    }

    @Override
    public void run() {
        try {
            while (pista.esperarLimpieza()) {
                try {
                    System.out.println("Servicio de limpieza trabajando");
                    Thread.sleep(duracion);
                } finally {
                    pista.terminarLimpieza();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
