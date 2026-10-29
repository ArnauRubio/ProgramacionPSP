package ProgramacionRed.EjerciciosSockets.ProgSockets4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock4 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(4999)) {
            System.out.println("Servidor esperando conexiones...");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        atenderCliente(cliente);
                    }
                }).start();
            }
        }
    }

    private static void atenderCliente(Socket cliente) {
        try (Socket socket = cliente;
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
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

                int resultado;
                switch (opcion) {
                    case "1":
                        resultado = a + b;
                        break;
                    case "2":
                        resultado = a - b;
                        break;
                    case "3":
                        resultado = a * b;
                        break;
                    case "4":
                        resultado = a / b;
                        break;
                    default:
                        throw new IllegalStateException("Opcion inesperada: " + opcion);
                }
                salida.println("Resultado: " + resultado);
            }
        } catch (IOException e) {
            System.err.println("Error atendiendo al cliente: " + e.getMessage());
        }
    }
}
