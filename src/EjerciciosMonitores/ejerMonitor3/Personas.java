package EjerciciosMonitores.ejerMonitor3;

import java.util.Random;

public class Personas implements Runnable {
   int gente = 0;

    public Personas(int gente) {
        this.gente = gente;
    }

    public int getGente() {
        return gente;
    }

    Random r = new Random();
    int numero = r.nextInt(21) - 10;

    @Override
    public void run() {

        while (gente < 50) {
            gente = gente + numero;
        }

    }
}
