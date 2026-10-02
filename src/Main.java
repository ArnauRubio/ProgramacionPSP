import EjerciciosMonitores.ejerMonitor1.Clientes;
import EjerciciosMonitores.ejerMonitor1.Mesas;
import EjerciciosMonitores.ejerMonitor2.AccionesCuenta;
import EjerciciosMonitores.ejerMonitor2.CuentaMonitor;
import EjerciciosSyncronhized.Sync1.CuentaBancaria;
import EjerciciosSyncronhized.Sync2.Almacen;
import EjerciciosSyncronhized.Sync2.Carga;
import EjerciciosSyncronhized.Sync2.Empaquetado;
import Multihilos.Ejercicio5.CalcArray;
import Multihilos.Ejercicio5.CrearArray;
import Multihilos.Ejercicio6.Carrera;
import Multihilos.Ejercicio7.Contador;
import Multihilos.Ejercicio7.Control;

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

    int numeroHilos = Math.min(Runtime.getRuntime().availableProcessors(), array.length);
    CalcArray[] calculos = new CalcArray[numeroHilos];
    Thread[] hilos = new Thread[numeroHilos];

    for (int i = 0; i < numeroHilos; i++) {
        int inicio = i * array.length / numeroHilos;
        int fin = (i + 1) * array.length / numeroHilos;
        calculos[i] = new CalcArray(array, inicio, fin);
        hilos[i] = new Thread(calculos[i], "Calculador-" + (i + 1));
        hilos[i].start();
    }

    for (Thread hilo : hilos) {
        hilo.join();
    }

    long sumaTotal = 0;
    for (CalcArray calculo : calculos) {
        sumaTotal += calculo.getSuma();
    }

    double media = (double) sumaTotal / array.length;

    System.out.println("Suma total: " + sumaTotal);
    System.out.println("Media: " + media);

    */

    /*
    //ejer6
    Carrera.correrMismoRitmo();
    Carrera.correrRitmoPropio();
    */


    /*
    //ejer7
    Control compartido = new Control();
    Thread[] hilosContador = new Thread[4];

    for (int i = 0; i < hilosContador.length; i++) {
        hilosContador[i] = new Thread(new Contador(compartido), "Contador-" + (i + 1));
        hilosContador[i].start();
    }

    for (Thread hilo : hilosContador) {
        hilo.join();
    }

    System.out.println("Valor final del contador: " + compartido.getCont());
    */

    /*
    //sync1
    CuentaBancaria cuenta = new CuentaBancaria();
    Thread[] hilosCuenta = new Thread[10];

    for (int i = 0; i < 5; i++) {
        int numeroHilo = i + 1;
        hilosCuenta[i] = new Thread(() -> {
            for (int operacion = 0; operacion < 1000; operacion++) {
                cuenta.ingresar(10);
            }
        }, "Ingreso-" + numeroHilo);
        hilosCuenta[i].start();

        hilosCuenta[i + 5] = new Thread(() -> {
            for (int operacion = 0; operacion < 1000; operacion++) {
                cuenta.retirar(10);
            }
        }, "Retiro-" + numeroHilo);
        hilosCuenta[i + 5].start();
    }

    for (Thread hilo : hilosCuenta) {
        hilo.join();
    }
    System.out.println("Saldo final: " + cuenta.getSaldo() + " €");
    */

    /*
    //sync2
    Almacen amazon = new Almacen();
    Thread[] hilosAlmacen = new Thread[16];

    for (int i = 0; i < 8; i++) {
        hilosAlmacen[i] = new Thread(new Carga(amazon), "Carga-" + (i + 1));
        hilosAlmacen[i + 8] = new Thread(new Empaquetado(amazon), "Empaquetado-" + (i + 1));
    }
    for (Thread hilo : hilosAlmacen) {
        hilo.start();
    }
    for (Thread hilo : hilosAlmacen) {
        hilo.join();
    }
    System.out.println("Las unidades totales son: " + amazon.getUnidades());
    */

    /*
    //monitores1
    Mesas mesas = new Mesas(5);
    Thread[] hilosClientes = new Thread[10];
    for (int i = 0; i < hilosClientes.length; i++) {
        int idCliente = i + 1;
        hilosClientes[i] = new Thread(new Clientes(idCliente, mesas), "Cliente-" + idCliente);
        hilosClientes[i].start();
    }

    for (Thread hilo : hilosClientes) {
        hilo.join();
    }

    System.out.println("Restaurante cerrado. Mesas disponibles: " + mesas.getMesasDisponibles());
    */

    /*
    //monitor2
    CuentaMonitor cuentaMonitor = new CuentaMonitor();
    Thread[] hilosCuentaMonitor = new Thread[10];
    for (int i = 0; i < 5; i++) {
        hilosCuentaMonitor[i] = new Thread(new AccionesCuenta(cuentaMonitor, true), "Ahorrador-" + (i + 1));
        hilosCuentaMonitor[i + 5] = new Thread(new AccionesCuenta(cuentaMonitor, false), "Gastador-" + (i + 1));
    }
    for (Thread hilo : hilosCuentaMonitor) {
        hilo.start();
    }
    for (Thread hilo : hilosCuentaMonitor) {
        hilo.join();
    }
    System.out.println("Saldo final de la cuenta: " + cuentaMonitor.getSaldo() + " €");

     */

}