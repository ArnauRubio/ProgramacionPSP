package EjerciciosSemaforos.ejerSem2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Portatil {
    private boolean ocupada;

    private Semaphore sem = new Semaphore(3);


    public void usar(int idAlumno) throws InterruptedException {
        sem.acquire();
        ocupada = true;
        System.out.println(idAlumno + "quiere usar el portatil");

        System.out.println(idAlumno + "Ha reservado el portatil");
        Thread.sleep(100 + new Random().nextInt(2000));
        System.out.println(idAlumno + " Ha terminado");
        ocupada = false;
        sem.release();
        System.out.println("Permisos despues del release"+ sem.availablePermits());

    }
}
