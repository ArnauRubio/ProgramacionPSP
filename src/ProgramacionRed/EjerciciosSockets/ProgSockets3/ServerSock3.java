package ProgramacionRed.EjerciciosSockets.ProgSockets3;

import ProgramacionRed.EjerciciosSockets.ProgSockets2.ServerSock2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock3 {
    public static void main(String[] args) throws IOException {
        ServerSock3.servConnection sc = getSc();

        sc.salida().println("Hola, soy el servidor");
        while ((mensaje = sc.entrada().readLine()) != null) {

        }

        sc.cliente().close();
        sc.servidor().close();
    }

    private static ServerSock3.servConnection getSc() throws IOException {
        ServerSocket servidor = new ServerSocket(4999);
        System.out.println("Servidor esperando conexión...");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        ServerSock3.servConnection sc = new ServerSock3.servConnection(servidor, cliente, entrada, salida);
        return sc;
    }

    private record servConnection(ServerSocket servidor, Socket cliente, BufferedReader entrada, PrintWriter salida) {
    }
}
