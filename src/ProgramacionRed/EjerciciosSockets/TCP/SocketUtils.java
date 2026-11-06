package ProgramacionRed.EjerciciosSockets.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public final class SocketUtils {
    private SocketUtils() {
    }

    public static BufferedReader crearLector(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static PrintWriter crearEscritor(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    public static void iniciarServidorMultihilo(int puerto, Consumer<Socket> atenderCliente) throws IOException {
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexiones...");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());
                new Thread(() -> atenderCliente.accept(cliente)).start();
            }
        }
    }
}
