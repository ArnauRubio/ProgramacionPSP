package EjerciciosMonitores.ejerMonitor3;

public class Personas implements Runnable {
    private final int idPersona;
    private final Museo museo;

    public Personas(int idPersona, Museo museo) {
        if (museo == null) {
            throw new IllegalArgumentException("El museo no puede ser nulo");
        }
        this.idPersona = idPersona;
        this.museo = museo;
    }

    @Override
    public void run() {
        boolean dentro = false;
        try {
            museo.entrar(idPersona);
            dentro = true;
            Thread.sleep((long) (Math.random() * 1500) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (dentro) {
                museo.salir(idPersona);
            }
        }
    }
}
