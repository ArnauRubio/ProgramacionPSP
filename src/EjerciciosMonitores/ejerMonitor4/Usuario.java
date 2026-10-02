package EjerciciosMonitores.ejerMonitor4;

public class Usuario implements Runnable{
    int usuario = 0;
    Pista p;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            usuario = usuario + 1;
            p.pista = usuario;
        }

    }
}
