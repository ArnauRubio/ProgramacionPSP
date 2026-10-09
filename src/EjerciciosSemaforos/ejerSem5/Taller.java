package EjerciciosSemaforos.ejerSem5;

import java.util.concurrent.Semaphore;

public class Taller {
    int mangas_Max = 12;
    int cuerpos_Max = 6;
    int mangas_Actuales = 0;
    int cuerpos_Actuales = 0;
    int jerseys;

    Semaphore sem_Mangas = new Semaphore(1);
    Semaphore sem_Cuerpos = new Semaphore(1);
    Semaphore sem_ensamble = new Semaphore(1);

    public void coser_Mangas() throws InterruptedException {
        sem_Mangas.acquire();
        while (mangas_Actuales >= mangas_Max) {
            System.out.println("La maquina de mangas espera a vaciar su cesta");
            wait();
        }
        mangas_Actuales++;

        sem_Mangas.release();
    }

    public void coser_Cuerpos() throws InterruptedException {
        sem_Cuerpos.acquire();
        while (cuerpos_Actuales >= cuerpos_Max) {
            System.out.println("La maquina de cuerpos espera a vaciar su cesta");
            wait();
        }
        cuerpos_Actuales++;

        sem_Cuerpos.release();
    }

    public void coser_Jerseys() throws InterruptedException {
        sem_ensamble.acquire();
        while (cuerpos_Actuales < 1 && mangas_Actuales < 2) {
            System.out.println("La maquina de ensamblaje espera por piezas");
            wait();
        }
        jerseys++;

        sem_ensamble.release();
    }

}
