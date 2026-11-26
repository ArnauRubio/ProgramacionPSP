package ProgramacionSegura.Ejer6;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;
import ProgramacionSegura.Ejer5.ServerSeguro1;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class ServerAsimetricoSeguro1 {
    private static final String ALGORITMO = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static KeyPair generarClaves() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048); // 2048 bits es el mínimo estándar (3072 o 4096 para mayor seguridad a largo plazo)
        return gen.generateKeyPair();
    }

    public static String descifrar(byte[] msg, PrivateKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] descifrado = cipher.doFinal(msg);
        return new String(descifrado, StandardCharsets.UTF_8);
    }

     static void main(String[] args) throws Exception {
         ServerAsimetricoSeguro1.servConnection sc = getSc();

         sc.salida().println("Hola, soy el servidor");
         String mensajeCifrado = sc.entrada().readLine();
         if (mensajeCifrado != null) {
             String descifrado = descifrar(Base64.getDecoder().decode(mensajeCifrado), generarClaves().getPrivate());
             System.out.println("Mensaje del cliente: " + descifrado);
             sc.salida().println(descifrado.toUpperCase());
         }

         sc.cliente().close();
         sc.servidor().close();
    }

    private static ServerAsimetricoSeguro1.servConnection getSc() throws IOException {
        ServerSocket servidor = new ServerSocket(4999);
        System.out.println("Servidor esperando conexión....");
        Socket cliente = servidor.accept(); // Espera conexión
        System.out.println("Cliente conectado");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        return new ServerAsimetricoSeguro1.servConnection(servidor, cliente, entrada, salida);
    }

    private record servConnection(ServerSocket servidor, Socket cliente, BufferedReader entrada, PrintWriter salida) {
    }
}

