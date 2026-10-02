package EjerciciosMonitores.ejerMonitor4;

public class Limpieza implements Runnable{
    String l = "La pista esta limpia";
    String nl = "La pista necesita limpieza";

    public Limpieza(String l, String nl) {
        this.l = l;
        this.nl = nl;
    }

    public String getL() {
        return l;
    }

    public String getNl() {
        return nl;
    }

    @Override
    public void run() {


    }
}
