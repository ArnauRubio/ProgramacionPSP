package ProgramacionMultiprocesos.EjerciciosMonitores.ejerMonitor4;

public class Usuario implements Runnable {
    private final int idUsuario;
    private final Pista pista;

    public Usuario(int idUsuario, Pista pista) {
        this.idUsuario = idUsuario;
        this.pista = pista;
    }

    @Override
    public void run() {
        boolean reservada = false;
        try {
            pista.reservar(idUsuario);
            reservada = true;
            Thread.sleep((long) (Math.random() * 1000) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (reservada) {
                pista.terminarUso(idUsuario);
            }
        }
    }
}
