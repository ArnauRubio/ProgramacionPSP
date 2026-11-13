package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets8;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockTCP8 {
        public static void main(String[] args) throws Exception {
            ServerSocket servidor = new ServerSocket(6000);
            System.out.println("Esperando objeto...");
            Socket socket = servidor.accept();

            ObjectInputStream inObjeto = new
                    ObjectInputStream(socket.getInputStream());
            CalculadoraOTCP calc = (CalculadoraOTCP) inObjeto.readObject(); // Se recibe el objeto
            System.out.println("Recibido: " + calc);
            socket.close();
            servidor.close();
        }
    private static void atenderCliente(Socket cliente) {
        try (Socket socket = cliente;
             BufferedReader entrada = SocketUtils.crearLector(socket);
             PrintWriter salida = SocketUtils.crearEscritor(socket)) {
            salida.println("Hola, soy el servidor");

            int total = 0;
            String numero;
            while ((numero = entrada.readLine()) != null && !numero.equals("0")) {
                try {
                    total = total + Integer.parseInt(numero);
                    salida.println("Resultado: " + total);
                } catch (NumberFormatException e) {
                    salida.println("Entrada no valida: introduce un numero entero");
                }
            }
        } catch (IOException e) {
            System.err.println("Error atendiendo al cliente: " + e.getMessage());
        }
    }
}
