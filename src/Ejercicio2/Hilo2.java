package Ejercicio2;

public class Hilo2 implements Runnable {
    @Override
    public void run() {
        for (char i = 'a'; i < 'z'; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getState());
        }
    }
}
