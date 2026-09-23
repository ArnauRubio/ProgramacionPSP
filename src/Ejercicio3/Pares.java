package Ejercicio3;

public class Pares implements Runnable {
    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
            }
        }
    }
}
