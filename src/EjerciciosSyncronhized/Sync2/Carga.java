package EjerciciosSyncronhized.Sync2;

public class Carga implements Runnable{
    private Almacen almacen;

    public Carga(Almacen almacen, String nombre) {
        super();
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                almacen.carga(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " Tiene: " + almacen.getUnidades() + " unidades");
        }
    }
}
