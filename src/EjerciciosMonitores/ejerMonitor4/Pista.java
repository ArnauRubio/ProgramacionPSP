package EjerciciosMonitores.ejerMonitor4;

public class Pista {
   boolean libre;
    boolean ocupada;
    boolean pendiente_limpieza;
    boolean limpiada;

   public synchronized void libre() throws InterruptedException {
       if (!libre){
           System.out.println("Pista ocupada");
           wait();
       }
       ocupada = true;
       System.out.println("La pista ha sido ocupada por: " + usuario);
   }

   public synchronized void ocupada() throws InterruptedException {
       if (ocupada) {
           Thread.sleep(2000);
       }else {
           pendiente_limpieza = true;
       }
   }

   public synchronized void porLimpiar(){
       if (pendiente_limpieza){

       }
   }
}
