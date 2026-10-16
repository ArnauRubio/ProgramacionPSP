package ProgramacionRed.EjerciciosSockets.ProgSockets2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock2 {
    public static void main(String[] args) throws IOException {
        cliConnection cC = getCC();

        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.salida().println("Hola servidor, soy el cliente");
        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.salida().println("Cuentame un chiste");
        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.salida().println("tu vida");
        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.socket().close();
    }

    private static cliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new
                PrintWriter(socket.getOutputStream(), true);
        cliConnection cC = new cliConnection(socket, entrada, salida);
        return cC;
    }

    private record cliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) {
    }
}
