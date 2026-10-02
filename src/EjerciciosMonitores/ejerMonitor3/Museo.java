package EjerciciosMonitores.ejerMonitor3;

public class Museo {
    int sala = 0;


    public Museo(int sala) {
        this.sala = sala;
    }

    public int getSala() {
        return sala;
    }

    public synchronized void tempCheck(double grados, int gente) throws InterruptedException {
        while (grados >= 30) {
            wait();
            grados = grados - 2;
        }
        sala = sala + gente;
        grados = grados + 1;
        System.out.println("La temperatura es: " + grados);
        notifyAll();
    }

    public synchronized void genteCheck(int gente, double grados) throws InterruptedException {
        while (grados >= 30 || gente > 35) {
            wait();
        }
        sala = sala + gente;
        System.out.println("La gente en la sala es: " + gente);

        notifyAll();
    }

   /* public synchronized void notifTemp(double temp){
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        System.out.println("la temperatura es : " + tem);
        if (temp>umbral){
            nMaxPers=MaxPersAltaT;
        }
        if (temp<umbral){
            nMaxPers=nMaxPersNormalT;
        }
    }*/
}
