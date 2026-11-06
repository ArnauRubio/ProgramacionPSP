package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteSockUDP6 {
    static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress destino = InetAddress.getByName("localhost");
        String mensaje = "Hola servidor UDP";
        byte[] datos = mensaje.getBytes();
        DatagramPacket paquete = new DatagramPacket(datos, datos.length, destino, 5000);
        socket.send(paquete); // Envía mensaje

        byte[] buffer = new byte[500];
        System.out.println("Servidor dice:");
        DatagramPacket paq = new DatagramPacket(buffer, buffer.length);
        socket.receive(paq);
        String mensaje2 = new String(paq.getData()).trim();
        System.out.println("Hora del servidor: " + mensaje2);
        socket.close();
    }
}
