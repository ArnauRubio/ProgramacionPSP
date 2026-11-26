package ProgramacionSegura.Ejer5;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class ServerSeguro1 {
    private static final byte[] CLAVE_COMPARTIDA = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);

    static void main(String[] args) throws Exception {
        ServerSeguro1.servConnection sc = getSc();
        SecretKey llave = new SecretKeySpec(CLAVE_COMPARTIDA, "AES");

        sc.salida().println("Hola, soy el servidor");
        String mensajeCifrado = sc.entrada().readLine();
        if (mensajeCifrado != null) {
            String descifrado = descifrar(Base64.getDecoder().decode(mensajeCifrado), llave);
            System.out.println("Mensaje del cliente: " + descifrado);
            sc.salida().println(descifrado.toUpperCase());
        }

        sc.cliente().close();
        sc.servidor().close();
    }

    private static ServerSeguro1.servConnection getSc() throws IOException {
        ServerSocket servidor = new ServerSocket(4999);
        System.out.println("Servidor esperando conexión....");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        return new servConnection(servidor, cliente, entrada, salida);
    }

    private record servConnection(ServerSocket servidor, Socket cliente, BufferedReader entrada, PrintWriter salida) {
    }


    public static byte[] cifrar(String texto, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        return cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
    }

    public static String descifrar(byte[] cifrado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        return new String(cipher.doFinal(cifrado), StandardCharsets.UTF_8);
    }
}
