package Sync2;

public class Empaquetado implements Runnable{
    private Almacen almacen;

    public Empaquetado(Almacen almacen, String nombre) {
        super();
        this.almacen = almacen;
    }
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                almacen.empaquetar(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " Tiene: " + almacen.getUnidades() + " unidades");
        }
    }
}
