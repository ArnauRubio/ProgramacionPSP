package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets8;

import ProgramacionRed.EjerciciosSockets.TCP.SocketUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSockTCP8 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6000);
        BufferedReader entrada = SocketUtils.crearLector(socket);
        PrintWriter salida = SocketUtils.crearEscritor(socket);
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        {

            while (true) {
                System.out.print("Introduce tu numero a multiplicar o 0 para salir: ");
                String numero1 = consola.readLine();
                String numero2 = consola.readLine();
                if (numero1 == null || numero2 == null) {
                    break;
                }
                salida.println(numero1 + " " + numero2);
                if (numero1.equals("0") || numero2.equals("0")) {
                    break;
                }

                String respuesta = entrada.readLine();
                if (respuesta == null) {
                    System.out.println("El servidor ha cerrado la conexion");
                    break;
                }
                System.out.println("Servidor dice: " + respuesta);

                CalculadoraOTCP calc = new CalculadoraOTCP(Integer.parseInt(numero1), Integer.parseInt(numero2));
                ObjectOutputStream outObjeto = new
                        ObjectOutputStream(socket.getOutputStream());
                outObjeto.writeObject(calc); // Envía el objeto
                socket.close();
            }

        }
    }
}
