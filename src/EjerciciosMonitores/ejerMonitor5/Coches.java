package EjerciciosMonitores.ejerMonitor5;

import java.util.Random;

public class Coches implements Runnable {
    private final int idVehiculo;
    private final int peso;
    private final Puente puente;

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

    public static void main(String[] args) throws InterruptedException {
        Puente puente = new Puente();
        Random random = new Random();
        Thread[] hilos = new Thread[20];

        for (int i = 0; i < hilos.length; i++) {
            int peso = 1_000 + random.nextInt(5_001);
            hilos[i] = new Thread(new Coches(i + 1, peso, puente), "Vehiculo-" + (i + 1));
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
    }
}
