package ProgramacionRed.EjerciciosSockets.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

public final class SocketUtils {
    private static final int TAMANO_BUFFER = 1024;
    public static final String GRUPO_MULTICAST = "230.0.0.1";
    public static final int PUERTO_MULTICAST = 5000;

    private SocketUtils() {
    }

    public static void iniciarServidorMultihilo(
            int puerto, BiConsumer<DatagramSocket, DatagramPacket> atenderCliente) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP abierto...");
            while (true) {
                DatagramPacket paquete = crearPaqueteRecepcion();
                socket.receive(paquete);
                new Thread(() -> atenderCliente.accept(socket, paquete)).start();
            }
        }
    }

    public static DatagramPacket crearPaqueteRecepcion() {
        byte[] buffer = new byte[TAMANO_BUFFER];
        return new DatagramPacket(buffer, buffer.length);
    }

    public static String leerMensaje(DatagramPacket paquete) {
        return new String(paquete.getData(), paquete.getOffset(), paquete.getLength(), StandardCharsets.UTF_8);
    }

    public static void unirGrupoMulticast(MulticastSocket socket, String direccionGrupo) throws IOException {
        InetAddress grupo = InetAddress.getByName(direccionGrupo);
        if (!grupo.isMulticastAddress()) {
            throw new IllegalArgumentException("La direccion no es un grupo multicast: " + direccionGrupo);
        }
        socket.joinGroup(grupo);
    }

    public static void enviarMensajeMulticast(
            DatagramSocket socket, String mensaje, String direccionGrupo, int puerto) throws IOException {
        InetAddress grupo = InetAddress.getByName(direccionGrupo);
        if (!grupo.isMulticastAddress()) {
            throw new IllegalArgumentException("La direccion no es un grupo multicast: " + direccionGrupo);
        }
        byte[] datos = mensaje.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(datos, datos.length, grupo, puerto));
    }

    public static void enviarMensaje(
            DatagramSocket socket, String mensaje, DatagramPacket paqueteRecibido) throws IOException {
        byte[] datos = mensaje.getBytes(StandardCharsets.UTF_8);
        DatagramPacket respuesta = new DatagramPacket(
                datos, datos.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
        socket.send(respuesta);
    }
}
