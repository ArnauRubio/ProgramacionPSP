import Ejercicio1.HiloContador;
import Ejercicio1.HiloSaludador;
import Ejercicio2.Hilo1;
import Ejercicio2.Hilo2;
import Ejercicio2.Hilo3;
import Ejercicio3.Impares;
import Ejercicio3.Pares;
import Ejercicio4.Ciudades;
import Ejercicio4.SumaPares;
import Ejercicio4.Tabla5;
import Ejercicio5.CalcArray;
import Ejercicio5.CrearArray;
import Prueba1.Hiloletras;
import Prueba1.Hilonumeros;

void main() throws InterruptedException {
   /*
   //prueba
   Hiloletras hl = new Hiloletras();
    Hilonumeros hn = new Hilonumeros();

    hl.start();
    hn.start();*/

   /*
   //ejer1
   HiloContador hc = new HiloContador();
    HiloSaludador hs = new HiloSaludador();

    System.out.println("inicio de los hilos");
    hc.start();
    hs.start();


    hc.join();
    hs.join();

    System.out.println("Fin de los hilos");*/

   /*
   //ejer2

    Hilo1 miHilo1 = new Hilo1();
    Thread hilo = new Thread(miHilo1, "Mayusculas");


    Hilo2 miHilo2 = new Hilo2();
    Thread hilo2 = new Thread(miHilo2, "Minusculas");


    Hilo3 miHilo3 = new Hilo3();
    Thread hilo3 = new Thread(miHilo3, "Numeros");

    hilo.start();
    hilo2.start();
    hilo3.start(); */

    /*
    //ejer3
    Pares miHilo = new Pares();
    Thread hilo = new Thread(miHilo, "Pares");

    Impares miHilo2 = new Impares();
    Thread hilo2 = new Thread(miHilo2, "Impares");

    hilo.start();
    hilo2.start();*/

    /*
    //ejer4
    Ciudades miHilo = new Ciudades();
    Thread hilo = new Thread(miHilo, "Ciudades");

    SumaPares miHilo2 = new SumaPares();
    Thread hilo2 = new Thread(miHilo2, "Sumas");

    Tabla5 miHilo3 = new Tabla5();
    Thread hilo3 = new Thread(miHilo3, "Tablas");

    System.out.println("Inicio de los hilos");


    hilo3.start();
    hilo3.join();
    System.out.println("Fin hilo1");
    System.out.println("Inicio hilo2");
    hilo2.start();
    hilo2.join();
    System.out.println("Fin hilo2");
    System.out.println("Inicio hilo3");
    hilo.start();
    hilo.join();
    System.out.println("Fin hilo3");
    System.out.println("Fin de los hilos");*/

    //ejer5
    CrearArray crearArray = new CrearArray();
    Thread hiloCrear = new Thread(crearArray);

    hiloCrear.start();
    hiloCrear.join();
    int[] array = crearArray.getArray();

    CalcArray calc1 = new CalcArray(array, 0, 500);
    CalcArray calc2 = new CalcArray(array, 500, 1000);
    CalcArray calc3 = new CalcArray(array, 1000, 1500);
    CalcArray calc4 = new CalcArray(array, 1500, 2000);

    Thread hilo1 = new Thread(calc1);
    Thread hilo2 = new Thread(calc2);
    Thread hilo3 = new Thread(calc3);
    Thread hilo4 = new Thread(calc4);

    hilo1.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();

    hilo1.join();
    hilo2.join();
    hilo3.join();
    hilo4.join();

    int sumaTotal = calc1.getSuma()
            + calc2.getSuma()
            + calc3.getSuma()
            + calc4.getSuma();

    double media = (double) sumaTotal / array.length;

    System.out.println("Suma total: " + sumaTotal);
    System.out.println("Media: " + media);
}


