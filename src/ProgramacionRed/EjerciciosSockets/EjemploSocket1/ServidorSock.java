package ProgramacionRed.EjerciciosSockets.EjemploSocket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSock {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor esperando conexión...");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new
                PrintWriter(cliente.getOutputStream(), true);
        salida.println("Hola, soy el servidor");
        System.out.println("Mensaje del cliente: " +
                entrada.readLine());
        cliente.close();
        servidor.close();

    }
}
