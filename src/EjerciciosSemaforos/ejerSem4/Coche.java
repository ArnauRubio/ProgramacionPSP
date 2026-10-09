package EjerciciosSemaforos.ejerSem4;

public class Coche implements Runnable{
    int idCoche;
    int peso;
    Parking parking;

    public Coche(int idCoche, int peso, Parking parking) {
        this.idCoche = idCoche;
        this.peso = peso;
        this.parking = parking;
    }

    @Override
    public void run() {
        boolean sentado = false;
        try {
            parking.entrar(idCoche, peso);
            sentado = true;
            Thread.sleep((long) (Math.random() * 4000) + 1000);
            System.out.println("Coche " + idCoche + " termina de usar la plaza");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
            if (sentado) {
                try {
                    parking.salir(idCoche, peso);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

