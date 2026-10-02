package Multihilos.Ejercicio6;

import java.util.concurrent.ThreadLocalRandom;

public class Atletas implements Runnable {
    private static final int distancia_meta = 50;
    private static final int paso_fijo = 5;
    private static final int pausa_fija = 100;

    private final String nombre;
    private final boolean ritmoVariable;

    public Atletas(String nombre, boolean ritmoVariable) {
        this.nombre = nombre;
        this.ritmoVariable = ritmoVariable;
    }

    @Override
    public void run() {
        int distancia = 0;
        System.out.println(nombre + " empieza la carrera");

        while (distancia < distancia_meta) {
            int paso;
            int pausa;
            if (ritmoVariable) {
                paso = ThreadLocalRandom.current().nextInt(2, 9);
                pausa = ThreadLocalRandom.current().nextInt(80, 201);
            } else {
                paso = paso_fijo;
                pausa = pausa_fija;
            }

            distancia = Math.min(distancia + paso, distancia_meta);
            System.out.println(nombre + " ha recorrido " + distancia + " metros");

            if (distancia < distancia_meta) {
                try {
                    Thread.sleep(pausa);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(nombre + " ha sido interrumpido");
                    return;
                }
            }
        }

        System.out.println(nombre + " ha terminado la carrera");
    }
}
