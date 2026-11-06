package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets6.Multicliente;

import ProgramacionRed.EjerciciosSockets.UDP.SocketUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;

public class ServerSockUDP6 {
    private static final int PUERTO = 5000;

    public static void main(String[] args) throws IOException {
        SocketUtils.iniciarServidorMultihilo(PUERTO, ServerSockUDP6::atenderCliente);
    }

    private static void atenderCliente(DatagramSocket socket, DatagramPacket paquete) {
        System.out.println("Mensaje recibido: " + SocketUtils.leerMensaje(paquete));
        System.out.println("Desde la direccion ip: " + paquete.getAddress());
        System.out.println("Desde el puerto: " + paquete.getPort());

        try {
            SocketUtils.enviarMensaje(socket, LocalDateTime.now().toString(), paquete);
        } catch (IOException e) {
            System.err.println("Error enviando respuesta: " + e.getMessage());
        }
    }
}
