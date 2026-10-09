package EjerciciosSemaforos.ejerSem5;

public class Cuerpos implements Runnable{
    Taller taller;

    @Override
    public void run() {
        try {
            taller.coser_Cuerpos();
            Thread.sleep((long) (Math.random() * 400) + 100);
            System.out.println("Se ha creado un nuevo cuerpo. Actualmente hay. " + taller.cuerpos_Actuales);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
