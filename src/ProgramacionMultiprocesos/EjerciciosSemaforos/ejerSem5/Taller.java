package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem5;

import java.util.concurrent.Semaphore;

public class Taller {
    int mangas_Max = 12;
    int cuerpos_Max = 6;
    int mangas_Actuales = 0;
    int cuerpos_Actuales = 0;
    int jerseys;

    Semaphore sem_Mangas = new Semaphore(1);
    Semaphore sem_MangasCheck = new Semaphore(1);
    Semaphore sem_Cuerpos = new Semaphore(1);
    Semaphore sem_CuerposCheck = new Semaphore(1);
    Semaphore sem_ensamble = new Semaphore(1);
    Semaphore sem_ensambleCheck = new Semaphore(1);

    public void coser_Mangas() throws InterruptedException {
        sem_Mangas.acquire();
        while (mangas_Actuales >= mangas_Max) {
            System.out.println("La maquina de mangas espera a vaciar su cesta");
            sem_MangasCheck.acquire();
        }
        mangas_Actuales++;

        sem_Mangas.release();
        sem_MangasCheck.release();
    }

    public void coser_Cuerpos() throws InterruptedException {
        sem_Cuerpos.acquire();
        while (cuerpos_Actuales >= cuerpos_Max) {
            System.out.println("La maquina de cuerpos espera a vaciar su cesta");
            sem_CuerposCheck.acquire();
        }
        cuerpos_Actuales++;

        sem_Cuerpos.release();
        sem_CuerposCheck.release();
    }

    public void coser_Jerseys() throws InterruptedException {
        sem_ensamble.acquire();

        while (cuerpos_Actuales < 1 && mangas_Actuales < 2) {
            System.out.println("La maquina de ensamblaje espera por piezas");
            sem_ensambleCheck.acquire();
        }

        jerseys++;

        sem_ensamble.release();
        sem_ensambleCheck.release();
    }

}
