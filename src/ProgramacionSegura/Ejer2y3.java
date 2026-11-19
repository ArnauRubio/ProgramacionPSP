package ProgramacionSegura;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

public class Ejer2y3 {
    private static final Pattern NOMBRE_USUARIO =
            Pattern.compile("[A-Za-z][A-Za-z0-9_]{4,14}");
    private static final Pattern CORREO =
            Pattern.compile("[A-Za-z0-9.-]+@empresa\\.(com|es)");
    private static final Pattern TELEFONO =
            Pattern.compile("(?:\\+34)?[67][0-9]{8}");
    static Logger logger= Logger.getLogger("auditoria_accesos.log");


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileHandler fh= new FileHandler("c:\\MyLogFile.log",true);
        fh.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(true);

        String nombreUsuario;
        while (true) {
            System.out.print("Introduce el nombre de usuario: ");
            nombreUsuario = scanner.nextLine().trim();
            if (NOMBRE_USUARIO.matcher(nombreUsuario).matches()) {
                break;
            }else{
                logger.log(Level.INFO,"Error en la insercion de el nombre ");
                logger.addHandler(fh);
            }
            System.out.println("Error: debe tener entre 5 y 15 caracteres, empezar por una letra "
                    + "y contener solo letras, dígitos o guion bajo (_).");
        }

        String correo;
        while (true) {
            System.out.print("Introduce el correo corporativo: ");
            correo = scanner.nextLine().trim();
            if (CORREO.matcher(correo).matches()) {
                break;
            }else{
                logger.log(Level.INFO,"Error en la insercion de el nombre de correo corporativo");
                logger.addHandler(fh);
            }
            System.out.println("Error: utiliza el formato nombre@empresa.com o nombre@empresa.es; "
                    + "el nombre solo puede contener letras, dígitos, puntos o guiones.");
        }

        String telefono;
        while (true) {
            System.out.print("Introduce el teléfono móvil de contacto: ");
            telefono = scanner.nextLine().trim();
            if (TELEFONO.matcher(telefono).matches()) {
                break;
            }else {
                logger.log(Level.INFO,"Error en la insercion de el numero de telefono");
                logger.addHandler(fh);
            }
            System.out.println("Error: introduce 9 dígitos empezando por 6 o 7, "
                    + "con el prefijo +34 opcional.");
        }

        int puerto;
        while (true) {
            System.out.print("Introduce el puerto de administración (1024-65535): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: el puerto debe ser un número entero.");
                scanner.nextLine();
                continue;
            }

            puerto = scanner.nextInt();
            scanner.nextLine();
            if (puerto >= 1024 && puerto <= 65535) {
                break;
            }else {
                logger.log(Level.WARNING,"Error en la insercion de el numero de puerto");
                logger.addHandler(fh);
            }
            System.out.println("Error: el puerto debe estar comprendido entre 1024 y 65535.");
        }

        System.out.println("Registro de administrador completado correctamente.");
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Puerto de administración: " + puerto);
    }

    /*
    ************ESTRUCTURA LOGS*******************************

      Logger logger= Logger.getLogger("auditoria_accesos.log");
        FileHandler fh= new FileHandler("c:\\MyLogFile.log",true);
        logger.setUseParentHandlers(true);

        SimpleFormatter formato = new SimpleFormatter();
        fh. setFormatter(formato);
        logger.setLevel(Level.SEVERE);
        logger.setLevel(Level.WARNING);
        logger.setLevel(Level.INFO);

        logger.log(Level.WARNING,"Mi primer log");
        logger.addHandler(fh);
     */
}
