package EjerciciosSyncronhized.Sync1;

public class CuentaBancaria {
    private double saldo = 1000.0;

    public synchronized void ingresar(double cantidad) {
        validarCantidad(cantidad);
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName()
                + " ingresa " + cantidad + " €. Saldo: " + saldo + " €");
    }

    public synchronized void retirar(double cantidad) {
        validarCantidad(cantidad);
        saldo -= cantidad;
        System.out.println(Thread.currentThread().getName()
                + " retira " + cantidad + " €. Saldo: " + saldo + " €");
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    private void validarCantidad(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }
}
