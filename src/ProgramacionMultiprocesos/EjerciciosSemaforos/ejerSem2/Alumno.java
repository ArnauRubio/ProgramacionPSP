package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem2;

public class Alumno implements Runnable {
    private int idAlumno;
    private Portatil portatil;

    public Alumno(int idAlumno, Portatil portatil) {
        this.idAlumno = idAlumno;
        this.portatil = portatil;
    }

    @Override
    public void run() {
        try {
            portatil.usar(idAlumno);

            Thread.sleep((long) (Math.random() * 500) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
