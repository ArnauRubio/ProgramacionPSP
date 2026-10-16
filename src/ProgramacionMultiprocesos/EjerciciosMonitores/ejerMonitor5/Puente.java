package ProgramacionMultiprocesos.EjerciciosMonitores.ejerMonitor5;

import java.util.HashMap;
import java.util.Map;

public class Puente {
    private static final int peso_maximo = 15000;
    private static final int vehiculos_maximos = 5;

    private int pesoActual;
    private int vehiculosEnPuente;
    private final Map<Integer, Integer> vehiculos = new HashMap<>();

    public synchronized boolean entrar(int idVehiculo, int peso) throws InterruptedException {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso del vehículo debe ser mayor que cero");
        }
        if (peso > peso_maximo) {
            System.out.println("Vehículo " + idVehiculo + " no puede entrar: pesa " + peso
                    + " kg y supera el límite del puente (" + pesoActual + " kg soportados actualmente)");
            return false;
        }
        if (vehiculos.containsKey(idVehiculo)) {
            throw new IllegalStateException("El vehículo ya está en el puente: " + idVehiculo);
        }

        while (vehiculosEnPuente >= vehiculos_maximos || pesoActual + peso > peso_maximo) {
            System.out.println("Vehículo " + idVehiculo + " espera. Peso actual del puente: "
                    + pesoActual + " kg; vehículos: " + vehiculosEnPuente);
            wait();
        }
        if (vehiculos.containsKey(idVehiculo)) {
            throw new IllegalStateException("El vehículo ya está en el puente: " + idVehiculo);
        }
        vehiculos.put(idVehiculo, peso);
        vehiculosEnPuente++;
        pesoActual += peso;
        System.out.println("Vehículo " + idVehiculo + " entra (" + peso + " kg). Peso actual: "
                + pesoActual + " kg; vehículos: " + vehiculosEnPuente);
        return true;
    }

    public synchronized void salir(int idVehiculo, int peso) {
        Integer pesoRegistrado = vehiculos.get(idVehiculo);
        if (pesoRegistrado == null) {
            throw new IllegalStateException("El vehículo no está en el puente: " + idVehiculo);
        }
        if (peso != pesoRegistrado) {
            throw new IllegalArgumentException("Peso de salida no válido: " + peso);
        }
        vehiculos.remove(idVehiculo);
        vehiculosEnPuente--;
        pesoActual -= peso;
        System.out.println("Vehículo " + idVehiculo + " sale. Peso actual: "
                + pesoActual + " kg; vehículos: " + vehiculosEnPuente);
        notifyAll();
    }

    public synchronized int getPesoActual() {
        return pesoActual;
    }

    public synchronized int getVehiculosEnPuente() {
        return vehiculosEnPuente;
    }
}
