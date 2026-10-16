package ProgramacionRed.EjerciciosSockets.ProgSockets1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerSoc1 {
    public static void main(String[] args) throws IOException {
        LocalDateTime d =  LocalDateTime.now();
        ServerSocket servidor = new ServerSocket(4999);
        System.out.println("Servidor esperando conexión...");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new
                PrintWriter(cliente.getOutputStream(), true);
        salida.println("Hola, soy el servidor");
        System.out.println("Mensaje del cliente: " + entrada.readLine());
        salida.println("La fecha actual es: " + d);
        System.out.println("Mensaje del cliente: " + entrada.readLine());

        cliente.close();
        servidor.close();

    }
}
