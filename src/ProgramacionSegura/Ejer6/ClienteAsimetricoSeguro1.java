package ProgramacionSegura.Ejer6;

import ProgramacionSegura.Ejer5.ClienteSeguro1;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class ClienteAsimetricoSeguro1 {
    private static final String ALGORITMO = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static KeyPair generarClaves() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048); // 2048 bits es el mínimo estándar (3072 o 4096 para mayor seguridad a largo plazo)
        return gen.generateKeyPair();
    }

    public static byte[] cifrar(String msg, PublicKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        return cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));
    }

    static void main(String[] args) throws Exception {
        ClienteAsimetricoSeguro1.cliConnection cC = getCC();

        String mensajeSalida = "Hola servidor, soy el cliente";
        byte[] cifrado = cifrar(mensajeSalida, generarClaves().getPublic());
        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.salida().println(Base64.getEncoder().encodeToString(cifrado));

        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.socket().close();
    }

    private static ClienteAsimetricoSeguro1.cliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        return new ClienteAsimetricoSeguro1.cliConnection(socket, entrada, salida);
    }

    private record cliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) {
    }
}
