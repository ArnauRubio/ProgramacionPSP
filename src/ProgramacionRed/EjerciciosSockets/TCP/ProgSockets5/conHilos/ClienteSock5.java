package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets5.conHilos;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock5 {
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
                System.out.print("Introduce tu numero a sumar o 0 para salir: ");
                String numero = consola.readLine();
                if (numero == null) {
                    break;
                }
                salida.println(numero);
                if (numero.equals("0")) {
                    break;
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
