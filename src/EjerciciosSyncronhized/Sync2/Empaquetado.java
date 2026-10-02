package EjerciciosSyncronhized.Sync2;

public class Empaquetado implements Runnable{
    private final Almacen almacen;

    public Empaquetado(Almacen almacen) {
        this.almacen = almacen;
    }
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                almacen.empaquetar(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
