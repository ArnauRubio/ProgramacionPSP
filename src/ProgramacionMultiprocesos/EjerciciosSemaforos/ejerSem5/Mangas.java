package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem5;

public class Mangas implements Runnable {
    Taller taller;

    public Mangas(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {

            taller.coser_Mangas();
            Thread.sleep((long) (Math.random() * 40) + 10);
            System.out.println("Se ha creado una nueva manga. Actualmente hay. " + taller.mangas_Actuales);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
