package ProgramacionMultiprocesos.EjerciciosMonitores.ejerMonitor3;

public class Museo {
    private static final int AFORO_NORMAL = 50;
    private static final int AFORO_CON_CALOR = 35;
    private static final double UMBRAL_TEMPERATURA = 30.0;

    private int personas;
    private double temperatura;

    public Museo(int personas) {
        if (personas < 0 || personas > AFORO_NORMAL) {
            throw new IllegalArgumentException("El número inicial de personas debe estar entre 0 y 50");
        }
        this.personas = personas;
        this.temperatura = 20.0;
    }

    public synchronized int getPersonas() {
        return personas;
    }

    public synchronized int getLimiteAforo() {
        return temperatura > UMBRAL_TEMPERATURA ? AFORO_CON_CALOR : AFORO_NORMAL;
    }

    public synchronized double getTemperatura() {
        return temperatura;
    }

    public synchronized void entrar(int idPersona) throws InterruptedException {
        while (personas >= getLimiteAforo()) {
            System.out.println("Persona " + idPersona + " espera. Personas en la sala: "
                    + personas + ", aforo actual: " + getLimiteAforo());
            wait();
        }
        personas++;
        System.out.println("Persona " + idPersona + " entra. Personas en la sala: " + personas);
    }

    public synchronized void salir(int idPersona) {
        if (personas <= 0) {
            throw new IllegalStateException("No puede salir una persona si la sala está vacía");
        }
        personas--;
        System.out.println("Persona " + idPersona + " sale. Personas en la sala: " + personas);
        notifyAll();
    }

    public synchronized void notificarTemperatura(double temperatura) {
        if (!Double.isFinite(temperatura)) {
            throw new IllegalArgumentException("La temperatura debe ser un número finito");
        }
        int limiteAnterior = getLimiteAforo();
        this.temperatura = temperatura;
        int limiteActual = getLimiteAforo();
        System.out.println("Temperatura de la sala: " + temperatura + " °C. Aforo: " + limiteActual);
        if (limiteActual > limiteAnterior) {
            notifyAll();
        }
    }
}
