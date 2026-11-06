package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets5.conHilos;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSock5 {
    public static void main(String[] args) throws IOException {
        SocketUtils.iniciarServidorMultihilo(4999, ServerSock5::atenderCliente);
    }

    private static void atenderCliente(Socket cliente) {
        try (Socket socket = cliente;
             BufferedReader entrada = SocketUtils.crearLector(socket);
             PrintWriter salida = SocketUtils.crearEscritor(socket)) {
            salida.println("Hola, soy el servidor");

            int suma = 0;
            String numero;
            while ((numero = entrada.readLine()) != null && !numero.equals("0")) {
                try {
                    suma += Integer.parseInt(numero);
                    salida.println("Resultado: " + suma);
                } catch (NumberFormatException e) {
                    salida.println("Entrada no valida: introduce un numero entero");
                }
            }
        } catch (IOException e) {
            System.err.println("Error atendiendo al cliente: " + e.getMessage());
        }
    }
}
