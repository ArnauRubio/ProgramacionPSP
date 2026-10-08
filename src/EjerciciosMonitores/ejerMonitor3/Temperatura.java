package EjerciciosMonitores.ejerMonitor3;

import java.util.Random;

public class Temperatura implements Runnable {
    private final Museo museo;
    private final long intervalo;
    private final Random random = new Random();
    private double grados;

    public Temperatura(Museo museo, double grados, long intervalo) {
        if (museo == null) {
            throw new IllegalArgumentException("El museo no puede ser nulo");
        }
        if (intervalo <= 0) {
            throw new IllegalArgumentException("El intervalo debe ser mayor que cero");
        }
        this.museo = museo;
        this.grados = grados;
        this.intervalo = intervalo;
        museo.notificarTemperatura(grados);
    }

    public synchronized double getGrados() {
        return grados;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(intervalo);
                synchronized (this) {
                    grados = 20 + random.nextDouble() * 20;
                    museo.notificarTemperatura(grados);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
