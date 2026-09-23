package Ejercicio1;

public class HiloSaludador extends Thread{
    public void run() {

        System.out.println("Se ha iniciado el hilo saludador");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "- " + "Hola que tal");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Fin hilo saludador");
    }
}
