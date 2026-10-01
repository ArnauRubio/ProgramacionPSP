import EjerciciosMonitores.ejerMonitor1.Clientes;
import EjerciciosMonitores.ejerMonitor1.Mesas;

static void main(String[] args) throws InterruptedException {

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

    /*
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

    int sumaTotal = calc1.getSuma() + calc2.getSuma() + calc3.getSuma() + calc4.getSuma();

    double media = (double) sumaTotal / array.length;

    System.out.println("Suma1: " + calc1.getSuma());
    System.out.println("Suma2: " + calc2.getSuma());
    System.out.println("Suma3: " + calc3.getSuma());
    System.out.println("Suma4: " + calc4.getSuma());
    System.out.println("Suma total: " + sumaTotal);
    System.out.println("Media: " + media);*/

    /*
    //ejer6
    Carrera miCarrera = new Carrera();
    Thread hiloCarrera = new Thread(miCarrera);

    hiloCarrera.start();

    Atletas miAtleta = new Atletas();
    Thread hilo1 = new Thread(miAtleta, "Arnau");
    Atletas miAtleta2 = new Atletas();
    Thread hilo2 = new Thread(miAtleta2, "Laura");
    Atletas miAtleta3 = new Atletas();
    Thread hilo3 = new Thread(miAtleta3, "Alberto");

    hilo1.start();
    hilo2.start();
    hilo3.start();

    hilo1.join();
    hilo2.join();
    hilo3.join();
    System.out.println("La carrera ha terminado");*/

    /*
    //ejer7
    Control compartido = new Control();

    Contador miContador = new Contador(compartido);
    Contador miContador2 = new Contador(compartido);
    Contador miContador3 = new Contador(compartido);
    Contador miContador4 = new Contador(compartido);

    Thread hiloContador = new Thread(miContador, "contador1");
    Thread hiloContador2 = new Thread(miContador2, "contador2");
    Thread hiloContador3 = new Thread(miContador3, "contador3");
    Thread hiloContador4 = new Thread(miContador4, "contador4");

    hiloContador.start();
    hiloContador2.start();
    hiloContador3.start();
    hiloContador4.start();
    hiloContador.join();
    hiloContador2.join();
    hiloContador3.join();
    hiloContador4.join();

    System.out.println("Suma total: " + compartido);*/

    /*
    //sync1
    CuentaBancaria nCuenta = new CuentaBancaria();
    nCuenta.retirar();
    CuentaBancaria nCuenta2 = new CuentaBancaria();
    nCuenta2.ingresar();

    Thread miHilo1 = new Thread(nCuenta);
    Thread miHilo2 = new Thread(nCuenta2);

    miHilo1.start();
    miHilo2.start();

    miHilo1.join();
    miHilo2.join();*/

    /*
    //sync2
    Almacen amazon = new Almacen();

    Carga miCarga1 = new Carga(amazon, "Amazon");
    Thread miHilo1 = new Thread(miCarga1, "Hilo1");
    Carga miCarga2 = new Carga(amazon, "Amazon");
    Thread miHilo2 = new Thread(miCarga2, "Hilo2");
    Carga miCarga3 = new Carga(amazon, "Amazon");
    Thread miHilo3 = new Thread(miCarga3, "Hilo3");
    Carga miCarga4 = new Carga(amazon, "Amazon");
    Thread miHilo4 = new Thread(miCarga4, "Hilo4");
    Carga miCarga5 = new Carga(amazon, "Amazon");
    Thread miHilo5 = new Thread(miCarga5, "Hilo5");
    Carga miCarga6 = new Carga(amazon, "Amazon");
    Thread miHilo6 = new Thread(miCarga6, "Hilo6");
    Carga miCarga7 = new Carga(amazon, "Amazon");
    Thread miHilo7 = new Thread(miCarga7, "Hilo7");
    Carga miCarga8 = new Carga(amazon, "Amazon");
    Thread miHilo8 = new Thread(miCarga8, "Hilo8");

    Empaquetado miEmpaquetado1 = new Empaquetado(amazon, "Amazon");
    Thread miHilo9 = new Thread(miEmpaquetado1, "Hilo9");
    Empaquetado miEmpaquetado2 = new Empaquetado(amazon, "Amazon");
    Thread miHilo10 = new Thread(miEmpaquetado2, "Hilo10");
    Empaquetado miEmpaquetado3 = new Empaquetado(amazon, "Amazon");
    Thread miHilo11 = new Thread(miEmpaquetado3, "Hilo11");
    Empaquetado miEmpaquetado4 = new Empaquetado(amazon, "Amazon");
    Thread miHilo12 = new Thread(miEmpaquetado4, "Hilo12");
    Empaquetado miEmpaquetado5 = new Empaquetado(amazon, "Amazon");
    Thread miHilo13 = new Thread(miEmpaquetado5, "Hilo13");
    Empaquetado miEmpaquetado6 = new Empaquetado(amazon, "Amazon");
    Thread miHilo14 = new Thread(miEmpaquetado6, "Hilo14");
    Empaquetado miEmpaquetado7 = new Empaquetado(amazon, "Amazon");
    Thread miHilo15 = new Thread(miEmpaquetado7, "Hilo15");
    Empaquetado miEmpaquetado8 = new Empaquetado(amazon, "Amazon");
    Thread miHilo16 = new Thread(miEmpaquetado8, "Hilo16");

    miHilo1.start();
    miHilo2.start();
    miHilo3.start();
    miHilo4.start();
    miHilo5.start();
    miHilo6.start();
    miHilo7.start();
    miHilo8.start();

    miHilo9.start();
    miHilo10.start();
    miHilo11.start();
    miHilo12.start();
    miHilo13.start();
    miHilo14.start();
    miHilo15.start();
    miHilo16.start();

    miHilo1.join();
    miHilo2.join();
    miHilo3.join();
    miHilo4.join();
    miHilo5.join();
    miHilo6.join();
    miHilo7.join();
    miHilo8.join();
    miHilo9.join();
    miHilo10.join();
    miHilo11.join();
    miHilo12.join();
    miHilo13.join();
    miHilo14.join();
    miHilo15.join();
    miHilo16.join();
    System.out.println("Las unidades totales son: " + amazon.getUnidades());
 /*Otra forma de crear  y lanzar hilos
        Thread[] hilos=new Thread[4];
        for (int i = 0; i <3 ; i++) {
            hilos[i]=new Hilo();
            hilos[i].start();
        }*/

    //monitores1
    Thread[] hilos=new Thread[10];
    for (int i = 0; i < 10; i++) {
        Clientes clientes = new Clientes(i);
       Mesas mesas = new Mesas(5);
       Thread hiloMesa = new Thread(clientes);

       hilos[i] = new Thread();
       hilos[i].start();

    }



}