package ProgramacionRed.EjerciciosSockets.ProgSockets4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock4 {
    public static void main(String[] args) throws IOException {
        try (CliConnection conexion = getCC();
             BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
            String saludo = conexion.entrada().readLine();
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

                conexion.salida().println(opcion);
                if (opcion.equals("5")) {
                    System.out.println("Servidor dice: " + conexion.entrada().readLine());
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
                    conexion.salida().println(primerNumero);
                    conexion.salida().println(segundoNumero);
                }

                String respuesta = conexion.entrada().readLine();
                if (respuesta == null) {
                    System.out.println("El servidor ha cerrado la conexion");
                    break;
                }
                System.out.println("Servidor dice: " + respuesta);
            }
        }
    }

    private static CliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        return new CliConnection(socket, entrada, salida);
    }

    private record CliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) implements AutoCloseable {
        @Override
        public void close() throws IOException {
            socket.close();
        }
    }
}
