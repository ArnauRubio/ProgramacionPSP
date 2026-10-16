package ProgramacionMultiprocesos.EjerciciosSemaforos.ejerSem4;

import java.util.concurrent.Semaphore;

public class Parking {
    int peso_Maximo = 50000;
    int capacidad_Max = 35;
    int peso_Actual;
    int plazasDisponibles = capacidad_Max;

    Semaphore sem = new Semaphore(10);
    Semaphore sem_Cont = new Semaphore(1);

    public synchronized int getplazasDisponibles() {
        return plazasDisponibles;
    }

    public void entrar(int idCoche, int peso) throws InterruptedException {
        sem.acquire();
        while (plazasDisponibles <= 0 || peso_Actual + peso > peso_Maximo) {
            System.out.println("Coche " + idCoche + " espera por una plaza");
            System.out.println("El peso actual es: " + peso_Actual + " La Capacidad actual es: " + (capacidad_Max-plazasDisponibles));
            wait();
        }

        sem_Cont.acquire(1);
        peso_Actual = peso_Actual + peso;
        plazasDisponibles--;
        sem_Cont.release(1);
        System.out.println("Coche " + idCoche + " ocupa una plaza. Plazas disponibles: " + plazasDisponibles);
    }

    public void salir(int idCoche, int peso) throws InterruptedException {
        sem_Cont.acquire(1);
        plazasDisponibles++;
        peso_Actual = peso_Actual - peso;
        sem_Cont.release(1);
        System.out.println("Coche " + idCoche + " libera una plaza. Plazas disponibles: " + plazasDisponibles);
        System.out.println("El peso actual es: " + peso_Actual + " La Capacidad actual es: " + (capacidad_Max-plazasDisponibles));
        sem.release();
        System.out.println("Permisos despues del release"+ sem.availablePermits());
    }
}
