package Multihilos.Ejercicio6;

public class Carrera {
    private static final String[] nombres = {"Arnau", "Laura", "Alberto"};

    public static void correrMismoRitmo() throws InterruptedException {
        System.out.println("FINAL DE 50 METROS - TODOS AL MISMO RITMO");
        System.out.println("==========================================");
        correr(false);
    }

    public static void correrRitmoPropio() throws InterruptedException {
        System.out.println();
        System.out.println("FINAL DE 50 METROS - CADA ATLETA A SU RITMO");
        System.out.println("============================================");
        correr(true);
    }

    private static void correr(boolean ritmoVariable) throws InterruptedException {
        Thread[] hilos = new Thread[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            Atletas atleta = new Atletas(nombres[i], ritmoVariable);
            hilos[i] = new Thread(atleta, nombres[i]);
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        System.out.println("La carrera ha terminado");
    }
}
