package EjerciciosSemaforos.ejerSem1;

import java.util.concurrent.Semaphore;

public class Estudiante implements Runnable {
    private int idEstudiante;
    private Impresora impresora;

    public Estudiante(int idEstudiante, Impresora impresora) {
        this.idEstudiante = idEstudiante;
        this.impresora = impresora;
    }

    @Override
    public void run() {
        try {
            impresora.imprimir(idEstudiante);

            Thread.sleep((long) (Math.random() * 500) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

