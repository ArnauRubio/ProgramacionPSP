package EjerciciosMonitores.ejerMonitor3;

public class Temperatura implements Runnable {
  double grados = 20;

    public Temperatura(double grados) {
        this.grados = grados;
    }

    public double getGrados() {
        return grados;
    }

    @Override
    public void run() {
        grados = Math.random() + 1;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
