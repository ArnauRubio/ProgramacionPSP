package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets6.Multicliente;

import ProgramacionRed.EjerciciosSockets.UDP.SocketUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class ClienteSockUDP6 {
    private static final int PUERTO_SERVIDOR = 5000;

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress servidor = InetAddress.getByName("localhost");
            enviarMensaje(socket, "Hola servidor UDP", servidor);

            DatagramPacket respuesta = SocketUtils.crearPaqueteRecepcion();
            socket.receive(respuesta);
            System.out.println("Hora del servidor: " + SocketUtils.leerMensaje(respuesta));
        }
    }

    private static void enviarMensaje(DatagramSocket socket, String mensaje, InetAddress servidor)
            throws IOException {
        byte[] datos = mensaje.getBytes(StandardCharsets.UTF_8);
        DatagramPacket paquete = new DatagramPacket(datos, datos.length, servidor, PUERTO_SERVIDOR);
        socket.send(paquete);
    }
}
