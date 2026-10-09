package EjerciciosSemaforos.ejerSem5;

public class Mangas implements Runnable{
    Taller taller;

    @Override
    public void run() {
        try {
            taller.coser_Jerseys();
            Thread.sleep((long) (Math.random() * 40) + 10);
            System.out.println("Se ha creado una nueva manga. Actualmente hay. " + taller.mangas_Actuales);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
