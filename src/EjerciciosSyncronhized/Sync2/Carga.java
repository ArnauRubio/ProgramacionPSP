package EjerciciosSyncronhized.Sync2;

public class Carga implements Runnable{
    private final Almacen almacen;

    public Carga(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            almacen.carga(10);
        }
    }
}
