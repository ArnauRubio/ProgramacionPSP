package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServerSockUDP6 {
    static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];
        System.out.println("Servidor UDP abierto...");
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
        socket.receive(paquete); // Espera mensaje

        System.out.println("Ha llegado un mensaje");
        String mensaje = new String(paquete.getData()).trim();
        System.out.println("Mensaje recibido: " + mensaje);
        System.out.println("Desde la direccion ip: " + paquete.getAddress());
        System.out.println("Desde el puerto: " + paquete.getPort());


        String t = String.valueOf(LocalDateTime.now());
        byte[] hora = t.getBytes();
        InetAddress destino = paquete.getAddress();
        int puerto = paquete.getPort();
        DatagramPacket paq = new DatagramPacket(hora, hora.length, destino, puerto);
        socket.send(paq);
        socket.close();
    }
}

