package Prueba1;

public class Hiloletras extends Thread{
   public void run() {
       for (char i = 'a'; i < 'z'; i++) {
           System.out.println(i);
       }
   }
}
