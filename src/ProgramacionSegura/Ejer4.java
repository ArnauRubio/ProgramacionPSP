package ProgramacionSegura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejer4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        String usuario = "";
        byte[] digest = new byte[0];
        byte[] digest1;
        do {
            System.out.println("Elige que quieres hacer: ");
            System.out.println("1. Registrarse \n"
                    + "2.Iniciar Sesion \n"
                    + "3. salir \n");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Introduce tu usuario y contraseña");
                    usuario = br.readLine();
                    String password = br.readLine();

                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(password.getBytes(StandardCharsets.UTF_8));
                        digest = md.digest();

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
                        md.update(contrLog.getBytes(StandardCharsets.UTF_8));
                        digest1 = md.digest();

                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }

                    if (usuLog.equals(usuario) && digest1.equals(digest)) {
                        System.out.println("Se ha registrado correctamente");
                    }else{
                        System.out.println("Login incorrecto");
                    }

            }

        }while (opcion != 3) ;
    }
}