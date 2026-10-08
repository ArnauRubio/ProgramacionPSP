package EjerciciosSemaforos;

import EjerciciosMonitores.ejerMonitor4.Pista;

import java.util.concurrent.Semaphore;

public class Estudiante implements Runnable {
    private int idEstudiante;
    private Impresora impresora;

    public Estudiante(int idEstudiante, Impresora impresora) {
        this.idEstudiante = idEstudiante;
        this.impresora = impresora;
    }

    Semaphore sem = new Semaphore(1);

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

