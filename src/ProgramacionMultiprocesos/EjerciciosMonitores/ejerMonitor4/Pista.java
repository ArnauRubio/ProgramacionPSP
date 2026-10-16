package ProgramacionMultiprocesos.EjerciciosMonitores.ejerMonitor4;

public class Pista {
    private boolean ocupada;
    private boolean limpiezaPendiente;
    private boolean limpiando;
    private boolean cerrada;

    public synchronized void reservar(int idUsuario) throws InterruptedException {
        while ((ocupada || limpiezaPendiente || limpiando) && !cerrada) {
            System.out.println("Usuario " + idUsuario + " espera: la pista no está disponible");
            wait();
        }
        if (cerrada) {
            throw new IllegalStateException("La pista está cerrada");
        }
        ocupada = true;
        System.out.println("Usuario " + idUsuario + " reserva la pista");
    }

    public synchronized void terminarUso(int idUsuario) {
        if (!ocupada) {
            throw new IllegalStateException("La pista no está ocupada");
        }
        ocupada = false;
        limpiezaPendiente = true;
        System.out.println("Usuario " + idUsuario + " termina. La pista debe limpiarse");
        notifyAll();
    }

    public synchronized boolean esperarLimpieza() throws InterruptedException {
        while (!limpiezaPendiente && !cerrada) {
            wait();
        }
        if (!limpiezaPendiente) {
            return false;
        }
        limpiezaPendiente = false;
        limpiando = true;
        return true;
    }

    public synchronized void terminarLimpieza() {
        if (!limpiando) {
            throw new IllegalStateException("No hay una limpieza en curso");
        }
        limpiando = false;
        System.out.println("Pista limpia y disponible");
        notifyAll();
    }

    public synchronized boolean estaDisponible() {
        return !ocupada && !limpiezaPendiente && !limpiando && !cerrada;
    }

    public synchronized void cerrar() {
        cerrada = true;
        notifyAll();
    }
}
