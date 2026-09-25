package Sync1;

public class ControlCuenta {
   private CuentaBancaria cuenta;

    public ControlCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public synchronized void sumar(){
        cuenta.saldo = cuenta.saldo + 10;
    }
    public synchronized void restar(){
        cuenta.saldo = cuenta.saldo - 10;
    }

    public double getSaldo() {
        return cuenta.saldo;
    }
}
