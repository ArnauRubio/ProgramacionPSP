package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ascensor {
     boolean ocupada;

    private Semaphore sem = new Semaphore(6);

    public void usar(int idPasajero) throws InterruptedException {
        sem.acquire();
        ocupada = true;
        System.out.println(idPasajero + "quiere usar el ascensor");

        System.out.println(idPasajero + "Esta usando el ascensor");
        Thread.sleep(100 + new Random().nextInt(2000));
        System.out.println(idPasajero + " Ha salido del ascensor");
        ocupada = false;
        sem.release();
        System.out.println("Permisos despues del release"+ sem.availablePermits());

    }
}
