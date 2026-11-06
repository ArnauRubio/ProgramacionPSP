package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets7;

import ProgramacionRed.EjerciciosSockets.UDP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MulticastSocket;

public class ServerSockUDP7 {
    public static void main(String[] args) throws IOException {
        try (MulticastSocket socket = new MulticastSocket();
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Servidor multicast activo. Escribe mensajes para enviarlos al grupo:");
            String mensaje;
            while ((mensaje = teclado.readLine()) != null) {
                SocketUtils.enviarMensajeMulticast(
                        socket, mensaje, SocketUtils.GRUPO_MULTICAST, SocketUtils.PUERTO_MULTICAST);
            }
        }
    }
}
