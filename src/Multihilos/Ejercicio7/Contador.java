package Multihilos.Ejercicio7;

public class Contador implements Runnable{

    private Control cont;

    public Contador(Control cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
       cont.sumar();
        System.out.println(cont);
    }
}
