package EjerciciosMonitores.ejerMonitor1;

public class Mesas {
    private int mesasDisponibles = 5;

    Clientes clientes;

    public Mesas(int mesasDisponibles) {
        this.mesasDisponibles = mesasDisponibles;
    }

    public int getMesasDisponibles() {
        return mesasDisponibles;
    }

    public synchronized void entrar(int idCliente){
        while(mesasDisponibles == 0){
            try {
                System.out.println("Cliente " + idCliente + " espera por una mesa");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            mesasDisponibles--;
            System.out.println("Cliente " + idCliente + " se ha sentado. Mesas disponibles: " + mesasDisponibles);
        }
    }

    public synchronized void salir(int idCliente){
        mesasDisponibles++;
        System.out.println("Cliente " + idCliente + " se ha ido. Mesas disponibles: " + mesasDisponibles);
        notifyAll();
    }
}
