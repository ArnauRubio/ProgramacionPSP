package Ejercicio1;

public class HiloContador extends Thread{
    public void run() {

        System.out.println("Se ha iniciado el hilo contador");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fin hilo contador");
    }
}
