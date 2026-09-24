package Ejercicio5;

public class CalcArray implements Runnable {
    private int[] n;
    private int inicio;
    private int fin;
    private int suma;

    public CalcArray(int[] n, int inicio, int fin) {
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

    public int getSuma() {
        return suma;
    }
}

