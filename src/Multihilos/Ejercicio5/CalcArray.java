package Multihilos.Ejercicio5;

public class CalcArray implements Runnable {
    private final int[] n;
    private final int inicio;
    private final int fin;
    private long suma;

    public CalcArray(int[] n, int inicio, int fin) {
        if (n == null) {
            throw new IllegalArgumentException("El array no puede ser null");
        }
        if (inicio < 0 || fin < inicio || fin > n.length) {
            throw new IllegalArgumentException("El rango debe estar dentro del array");
        }
        this.n = n;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {

        suma = 0;

        for (int i = inicio; i < fin; i++) {
            suma += n[i];
        }
    }

    public long getSuma() {
        return suma;
    }
}
