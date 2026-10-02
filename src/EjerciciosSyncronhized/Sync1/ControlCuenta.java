package EjerciciosSyncronhized.Sync1;

public class ControlCuenta {
    private final CuentaBancaria cuenta;

    public ControlCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public void sumar() {
        cuenta.ingresar(10);
    }

    public void restar() {
        cuenta.retirar(10);
    }

    public double getSaldo() {
        return cuenta.getSaldo();
    }
}
