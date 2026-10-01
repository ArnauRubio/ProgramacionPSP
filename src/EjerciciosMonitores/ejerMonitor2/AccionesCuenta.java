package EjerciciosMonitores.ejerMonitor2;

import EjerciciosSyncronhized.Sync1.ControlCuenta;

public class AccionesCuenta implements Runnable{
    CuentaMonitor control;

    public int saldo;

    @Override
    public void run() {
        ingresar();
        retirar();
    }

    public synchronized void ingresar(){
        while (saldo < 250){
            wait();
            System.out.println("No hay saldo sudiciente");
        }
        for (int i = 0; i < 1000; i++) {
            control.sumar();
            System.out.println("El saldo ahora mismo es de: " + control.getSaldo());
        }

    }
    public synchronized void retirar(){
        for (int i = 0; i < 1000; i++) {
            control.restar();
            System.out.println("El saldo ahora mismo es de: " + control.getSaldo());
        }
    }
}
