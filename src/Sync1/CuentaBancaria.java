package Sync1;

public class CuentaBancaria implements Runnable{
    ControlCuenta control;

    public int saldo;

    @Override
    public void run() {
        ingresar();
        retirar();
    }

    public void ingresar(){
        for (int i = 0; i < 1000; i++) {
            control.sumar();

        }
    }
    public void retirar(){
        for (int i = 0; i < 1000; i++) {
            control.restar();
        }
    }
}
