package ProgramacionSegura.Ejer5;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class ClienteSeguro1 {
    private static final byte[] CLAVE_COMPARTIDA =
            "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);

    static void main(String[] args) throws Exception {
        ClienteSeguro1.cliConnection cC = getCC();
        SecretKey llave = new SecretKeySpec(CLAVE_COMPARTIDA, "AES");

        String mensajeSalida = "Hola servidor, soy el cliente";
        byte[] cifrado = cifrar(mensajeSalida, llave);
        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.salida().println(Base64.getEncoder().encodeToString(cifrado));

        System.out.println("Servidor dice: " + cC.entrada().readLine());
        cC.socket().close();
    }

    private static ClienteSeguro1.cliConnection getCC() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        BufferedReader entrada = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new
                PrintWriter(socket.getOutputStream(), true);
        return new cliConnection(socket, entrada, salida);
    }

    private record cliConnection(Socket socket, BufferedReader entrada, PrintWriter salida) {
    }


    public static byte[] cifrar(String texto, SecretKey clave) throws Exception {
        return ServerSeguro1.cifrar(texto, clave);
    }
}
