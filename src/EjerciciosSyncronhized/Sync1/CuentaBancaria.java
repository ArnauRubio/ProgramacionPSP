package EjerciciosSyncronhized.Sync1;

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
            System.out.println("El saldo ahora mismo es de: " + control.getSaldo());
        }
    }
    public void retirar(){
        for (int i = 0; i < 1000; i++) {
            control.restar();
            System.out.println("El saldo ahora mismo es de: " + control.getSaldo());
        }
    }
}
