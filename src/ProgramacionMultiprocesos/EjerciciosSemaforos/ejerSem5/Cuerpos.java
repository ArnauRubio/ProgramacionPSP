package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem5;

public class Cuerpos implements Runnable {
    Taller taller;

    public Cuerpos(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {

            taller.coser_Cuerpos();
            Thread.sleep((long) (Math.random() * 600) + 600);
            System.out.println("Se ha creado un nuevo cuerpo. Actualmente hay. " + taller.cuerpos_Actuales);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
