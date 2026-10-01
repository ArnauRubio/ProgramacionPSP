package EjerciciosMonitores.ejerMonitor1;

public class Clientes implements Runnable{
   int idCliente;

   Mesas mesas;
    public Clientes(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public void run() {
       mesas.entrar(idCliente);

       try {
           Thread.sleep((long) (Math.random() * 5000) + 1000);
       } catch (InterruptedException e) {
          e.printStackTrace();
       }
       mesas.salir(idCliente);
    }
}
