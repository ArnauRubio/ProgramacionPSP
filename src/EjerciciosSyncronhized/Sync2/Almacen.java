package EjerciciosSyncronhized.Sync2;

public class Almacen {
    String nombre;
    int unidades = 100;

    public synchronized void carga(int cantidad) throws InterruptedException {
        for (int i = 0; i <= 500; i++) {
            this.unidades += cantidad;
        }
    }

    public synchronized void empaquetar(int cantidad) throws InterruptedException {
        while (this.unidades < cantidad) {
            System.out.println("Hilo sin stock!!!!!!");
            wait();
        }
        for (int i = 0; i <= 500; i++) {
            this.unidades -= cantidad;
        }
    }

    public int getUnidades() {
        return unidades;
    }
}
