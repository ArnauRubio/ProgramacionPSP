package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets4.conHilos;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock4 {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 4999);
             BufferedReader entrada = SocketUtils.crearLector(socket);
             PrintWriter salida = SocketUtils.crearEscritor(socket);
             BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
            String saludo = entrada.readLine();
            if (saludo == null) {
                System.out.println("El servidor ha cerrado la conexion");
                return;
            }
            System.out.println("Servidor dice: " + saludo);

            while (true) {
                System.out.println(
                        "Elige una operacion:\n" +
                                "1. Suma\n" +
                                "2. Resta\n" +
                                "3. Multiplicacion\n" +
                                "4. Division\n" +
                                "5. Salir");
                String opcion = consola.readLine();
                if (opcion == null) {
                    break;
                }

                salida.println(opcion);
                if (opcion.equals("5")) {
                    System.out.println("Servidor dice: " + entrada.readLine());
                    break;
                }

                if (opcion.matches("[1-4]")) {
                    System.out.println("Introduce el primer numero:");
                    String primerNumero = consola.readLine();
                    if (primerNumero == null) {
                        break;
                    }
                    System.out.println("Introduce el segundo numero:");
                    String segundoNumero = consola.readLine();
                    if (segundoNumero == null) {
                        break;
                    }
                    salida.println(primerNumero);
                    salida.println(segundoNumero);
                }

                String respuesta = entrada.readLine();
                if (respuesta == null) {
                    System.out.println("El servidor ha cerrado la conexion");
                    break;
                }
                System.out.println("Servidor dice: " + respuesta);
            }
        }
    }
}
