package Ejercicio4;

public class Tabla5 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }
    }
}
