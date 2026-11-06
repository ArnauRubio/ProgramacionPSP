package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets4.conHilos;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSock4 {
    public static void main(String[] args) throws IOException {
        SocketUtils.iniciarServidorMultihilo(4999, ServerSock4::atenderCliente);
    }

    private static void atenderCliente(Socket cliente) {
        try (Socket socket = cliente;
             BufferedReader entrada = SocketUtils.crearLector(socket);
             PrintWriter salida = SocketUtils.crearEscritor(socket)) {
            salida.println("Hola, soy el servidor");

            String opcion;
            while ((opcion = entrada.readLine()) != null) {
                if (opcion.equals("5")) {
                    salida.println("Hasta luego");
                    break;
                }
                if (!opcion.matches("[1-4]")) {
                    salida.println("Opcion no valida");
                    continue;
                }

                String primerNumero = entrada.readLine();
                String segundoNumero = entrada.readLine();
                if (primerNumero == null || segundoNumero == null) {
                    break;
                }

                int a;
                int b;
                try {
                    a = Integer.parseInt(primerNumero);
                    b = Integer.parseInt(segundoNumero);
                } catch (NumberFormatException e) {
                    salida.println("Error: introduce numeros enteros");
                    continue;
                }

                if (opcion.equals("4") && b == 0) {
                    salida.println("Error: no se puede dividir entre cero");
                    continue;
                }

                salida.println("Resultado: " + calcular(opcion, a, b));
            }
        } catch (IOException e) {
            System.err.println("Error atendiendo al cliente: " + e.getMessage());
        }
    }

    private static int calcular(String opcion, int a, int b) {
        switch (opcion) {
            case "1":
                return a + b;
            case "2":
                return a - b;
            case "3":
                return a * b;
            case "4":
                return a / b;
            default:
                throw new IllegalArgumentException("Opcion no valida: " + opcion);
        }
    }
}
