package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem5;

public class Ensamblar implements Runnable {
    Taller taller;

    public Ensamblar(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {

            taller.coser_Jerseys();
            Thread.sleep((long) (Math.random() * 400) + 100);
            System.out.println("Se ha creado un nuevo jersey. Actualmente hay. " + taller.jerseys);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
