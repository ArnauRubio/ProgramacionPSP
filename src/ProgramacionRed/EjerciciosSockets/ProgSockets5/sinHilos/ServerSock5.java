package ProgramacionRed.EjerciciosSockets.ProgSockets5.sinHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock5 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(4999)) {
            System.out.println("Servidor esperando conexiones...");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());
                new Thread(() -> atenderCliente5(cliente)).start();
            }
        }
    }
    private static void atenderCliente5(Socket cliente) {
        try (Socket socket = cliente;
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
            salida.println("Hola, soy el servidor");

            int contadorG = 0;
            String numero;
            while ((numero = entrada.readLine()) != null && !numero.equals("0")) {
                try {
                    contadorG += Integer.parseInt(numero);
                    salida.println("Resultado: " + contadorG);
                } catch (NumberFormatException e) {
                    salida.println("Entrada no válida: introduce un número entero");
                }
            }
        } catch (IOException e) {
            System.err.println("Error atendiendo al cliente: " + e.getMessage());
        }
    }
}
