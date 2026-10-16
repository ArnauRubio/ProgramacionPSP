package ProgramacionRed.EjerciciosSockets.ProgSockets3;

import ProgramacionRed.EjerciciosSockets.ProgSockets2.ClienteSock2;
import ProgramacionRed.EjerciciosSockets.ProgSockets2.ServerSock2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSock3 {
    public static void main(String[] args) throws IOException {
        ClienteSock3.cliConnection cC = getCC();

    }

    private static ClienteSock3.cliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new
                PrintWriter(socket.getOutputStream(), true);
        ClienteSock3.cliConnection cC = new ClienteSock3.cliConnection(socket, entrada, salida);
        return cC;
    }

    private record cliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) {
    }
}
