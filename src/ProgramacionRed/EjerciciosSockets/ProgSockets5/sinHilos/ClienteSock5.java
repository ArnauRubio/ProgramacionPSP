package ProgramacionRed.EjerciciosSockets.ProgSockets5.sinHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock5 {
    public static void main(String[] args) throws IOException {
        try (ClienteSock5.CliConnection conexion = getCC();
             BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
            String saludo = conexion.entrada().readLine();
            if (saludo == null) {
                System.out.println("El servidor ha cerrado la conexion");
                return;
            }
            System.out.println("Servidor dice: " + saludo);

            while (true) {
                System.out.print("Introduce tu número a sumar o 0 para salir: ");
                String numero = consola.readLine();
                if (numero == null) {
                    break;
                }
                conexion.salida().println(numero);
                if (numero.equals("0")) {
                    break;
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

    private static ClienteSock5.CliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        return new ClienteSock5.CliConnection(socket, entrada, salida);
    }

    private record CliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) implements AutoCloseable {
        @Override
        public void close() throws IOException {
            socket.close();
        }
    }

}
