package ProgramacionRed.EjerciciosSockets.EjemploSocket1;

import java.io.*;
import java.net.Socket;

public class ClienteSock {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new
                PrintWriter(socket.getOutputStream(), true);
        System.out.println("Servidor dice: " +
                entrada.readLine());
        salida.println("Hola servidor, soy el cliente");
        socket.close();
    }
}
