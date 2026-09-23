package Ejercicio2;

public class Hilo1 implements Runnable {
    @Override
    public void run() {
        for (char i = 'A'; i < 'Z'; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getState());
        }
    }
}
