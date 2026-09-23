package Ejercicio2;

public class Hilo3 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getState());
        }
    }
}
