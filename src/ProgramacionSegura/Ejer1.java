package ProgramacionSegura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejer1 {
    void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pat = null;
        int opcion;

        do {
            System.out.println("Elige que quieres hacer: ");
            System.out.println("1. Verificar Matricula \n"
                    + "2. Verificar DNI \n"
                    + "3. salir \n");
             opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la matricula: ");
                    String matricula = br.readLine();

                    pat = Pattern.compile("^[0-9]{4}-[A-Z]{3}$");

                    Matcher matMatricula = pat.matcher(matricula);
                    if (matMatricula.matches()) {

                        System.out.println("Matricula valida");
                    } else {
                        System.out.println("Matricula no valida");
                    }
                    break;
                case 2:
                    System.out.println("Introduce el DNI: ");
                    String dni = br.readLine();

                    pat = Pattern.compile("[0-9]{8}[a-zA-Z]");
                    Matcher matDNI = pat.matcher(dni);

                    if (matDNI.matches()) {
                        System.out.println("DNI valido");
                    } else {
                        System.out.println( "DNI no valido");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (opcion != 3);
    }
}
