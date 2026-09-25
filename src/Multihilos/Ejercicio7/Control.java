package Multihilos.Ejercicio7;

public class Control {
    int cont = 0;

    public synchronized void sumar(){
        cont = cont + 1;
    }

    public int getCont() {
        return cont;
    }
}
