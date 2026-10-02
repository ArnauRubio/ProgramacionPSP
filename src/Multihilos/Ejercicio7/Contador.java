package Multihilos.Ejercicio7;

public class Contador implements Runnable{
    private static final int incrementos = 5000;
    private final Control control;

    public Contador(Control control) {
        this.control = control;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementos; i++) {
            control.sumar();
        }
        System.out.println(Thread.currentThread().getName() + " ha terminado");
    }
}
