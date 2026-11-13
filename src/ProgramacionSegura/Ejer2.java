package ProgramacionSegura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ejer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        Pattern nUsuario = Pattern.compile("[a-zA-Z]{10,40}");
        System.out.println("Ingrese su nombre de ususario: ");
        String n = br.readLine();
        while (!scanner.hasNext(nUsuario)) {
            System.out.println("Formato incorrecto.");
            scanner.next();
            System.out.print("Introduce un nombre valido: ");
        }
        String dni = scanner.next(patronDni);
        System.out.println("Ingrese su correo corporativo: ");
        String c = br.readLine();
        System.out.println("Ingrese su Telefono: ");
        String t = br.readLine();
        System.out.println("Ingrese su puerto de admision: ");
        String pA = br.readLine();


    }
}
