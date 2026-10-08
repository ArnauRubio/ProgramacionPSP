package EjerciciosSemaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {
    private boolean ocupada;

private Semaphore sem = new Semaphore(1);


    public void imprimir(int idEstudiante) throws InterruptedException {
        sem.acquire();
        ocupada = true;
        System.out.println(idEstudiante + "quiere usar la impresora");

        System.out.println(idEstudiante + "Ha reservado la impresora");
        Thread.sleep(100 + new Random().nextInt(2000));
        System.out.println(idEstudiante + " Ha terminado");
        ocupada = false;
        sem.release();

    }

}
