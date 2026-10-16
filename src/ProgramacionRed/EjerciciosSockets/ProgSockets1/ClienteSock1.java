package ProgramacionRed.EjerciciosSockets.ProgSockets1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new
                PrintWriter(socket.getOutputStream(), true);
        System.out.println("Servidor dice: " + entrada.readLine());
        salida.println("Hola servidor, soy el cliente, quiero la fecha de hoy");
        System.out.println("Servidor dice: " + entrada.readLine());
        salida.println("gracias");
        socket.close();
    }
}
