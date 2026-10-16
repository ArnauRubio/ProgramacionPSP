package ProgramacionRed.EjerciciosSockets.ProgSockets2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock2 {
    public static void main(String[] args) throws IOException {
        servConnection sc = getSc();

        sc.salida().println("Hola, soy el servidor");
        String mensaje;
        while ((mensaje = sc.entrada().readLine()) != null) {
            String mayusculas = mensaje.toUpperCase();
            System.out.println("Mensaje del cliente: " + mensaje);
            sc.salida().println(mayusculas);
        }

        sc.cliente().close();
        sc.servidor().close();

    }

    private static servConnection getSc() throws IOException {
        ServerSocket servidor = new ServerSocket(4999);
        System.out.println("Servidor esperando conexión...");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        servConnection sc = new servConnection(servidor, cliente, entrada, salida);
        return sc;
    }

    private record servConnection(ServerSocket servidor, Socket cliente, BufferedReader entrada, PrintWriter salida) {
    }
}
