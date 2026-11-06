package ProgramacionRed.EjerciciosSockets.UDP.ProgSockets7;

import ProgramacionRed.EjerciciosSockets.UDP.SocketUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class ClienteSockUDP7 {
    public static void main(String[] args) throws IOException {
        try (MulticastSocket socket = new MulticastSocket(SocketUtils.PUERTO_MULTICAST)) {
            SocketUtils.unirGrupoMulticast(socket, SocketUtils.GRUPO_MULTICAST);
            System.out.println("Cliente unido al grupo multicast. Esperando mensajes...");

            while (true) {
                DatagramPacket paquete = SocketUtils.crearPaqueteRecepcion();
                socket.receive(paquete);
                System.out.println("Mensaje recibido: " + SocketUtils.leerMensaje(paquete));
            }
        }
    }
}
