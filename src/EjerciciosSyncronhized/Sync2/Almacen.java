package EjerciciosSyncronhized.Sync2;

public class Almacen {
    private int unidades = 100;

    public synchronized void carga(int cantidad) {
        validarCantidad(cantidad);
        unidades += cantidad;
        System.out.println(Thread.currentThread().getName()
                + " carga " + cantidad + " unidades. Stock: " + unidades);
        notifyAll();
    }

    public synchronized void empaquetar(int cantidad) throws InterruptedException {
        validarCantidad(cantidad);
        while (unidades < cantidad) {
            wait();
        }
        unidades -= cantidad;
        System.out.println(Thread.currentThread().getName()
                + " empaqueta " + cantidad + " unidades. Stock: " + unidades);
    }

    public synchronized int getUnidades() {
        return unidades;
    }

    private void validarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }
}
