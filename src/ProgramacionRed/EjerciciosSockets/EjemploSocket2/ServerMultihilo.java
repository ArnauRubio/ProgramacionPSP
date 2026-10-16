package ProgramacionRed.EjerciciosSockets.EjemploSocket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultihilo {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor activo...");
        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            new HiloCliente(cliente).start();
        }
    }
}
class HiloCliente extends Thread {
    private Socket socket;
    public HiloCliente(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new
                    PrintWriter(socket.getOutputStream(), true);
            salida.println("Conexión establecida con el servidor multihilo");
                    System.out.println("Cliente dice: " + entrada.readLine());
            socket.close();
        } catch (Exception e) {
            System.out.println("Error en hilo: " + e.getMessage());
        }
    }
}