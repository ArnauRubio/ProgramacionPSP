package ProgramacionSegura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HexFormat;

public class Ejer4 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        String usuario = "";
        byte[] digest = new byte[0];
        byte[] digest1;
        String hex = "";
        String hex1;
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        String contraSalteada = "";
        String contraSalteada1;

        do {
            System.out.println("Elige que quieres hacer: ");
            System.out.println("1. Registrarse \n"
                    + "2. Iniciar Sesion \n"
                    + "3. salir \n");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Introduce tu usuario y contraseña");
                    usuario = br.readLine();
                    String password = br.readLine();

                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");

                        byte[] hashConSalt = md.digest(password.getBytes(StandardCharsets.UTF_8));
                        contraSalteada = Arrays.toString(hashConSalt);
                        md.update(salt);
                        digest = md.digest(password.getBytes(StandardCharsets.UTF_8)); //constraseña hasheada + el salt

                        hex = HexFormat.of().withUpperCase().formatHex(digest); //el hash pasa a hexadecimal

                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Introduce tu usuario");
                    String usuLog = br.readLine();
                    System.out.println("Introduce tu contraseña");
                    String contrLog = br.readLine();

                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");

                        byte[] hashConSalt1 = md.digest(contrLog.getBytes(StandardCharsets.UTF_8));
                        contraSalteada1 = Arrays.toString(hashConSalt1);
                        md.update(salt);
                        digest1 = md.digest(contrLog.getBytes(StandardCharsets.UTF_8)); //constraseña hasheada + el salt

                        hex1 = HexFormat.of().withUpperCase().formatHex(digest1); //el hash pasa a hexadecimal

                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }

                    if (usuLog.equals(usuario) && hex1.equals(hex) && contraSalteada.equals(contraSalteada1)) {
                        System.out.println("Se ha registrado correctamente");
                        System.out.println("Contraseña: " + hex);
                        System.out.println("Contraseña introducida: " + hex1);
                        System.out.println("Salt: " + contraSalteada);
                        System.out.println("Salt: " + contraSalteada1);
                    } else {
                        System.out.println("Login incorrecto");
                        System.out.println("Contraseña: " + hex);
                        System.out.println("Contraseña introducida: " + hex1);
                        System.out.println("Salt: " + contraSalteada);
                        System.out.println("Salt: " + contraSalteada1);
                    }

            }

        } while (opcion != 3);
    }
}