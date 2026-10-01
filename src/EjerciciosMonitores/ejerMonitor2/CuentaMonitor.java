package EjerciciosMonitores.ejerMonitor2;

public class CuentaMonitor {
    private AccionesCuenta cuenta;

    public CuentaMonitor(AccionesCuenta cuenta) {
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
