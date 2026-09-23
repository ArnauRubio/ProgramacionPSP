package Ejercicio4;

public class SumaPares implements Runnable{
    @Override
    public void run() {
        int suma = 0;

        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                suma = suma + i;
                System.out.println(suma);
            }
        }
    }
}
