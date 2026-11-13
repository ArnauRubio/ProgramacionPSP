package ProgramacionRed.EjerciciosSockets.TCP.ProgSockets8;

import java.io.Serializable;

public class CalculadoraOTCP implements Serializable {
    int primerNumero;
    int segundoNumero;

    public CalculadoraOTCP(int primerNumero, int segundoNumero) {
        this.primerNumero = primerNumero;
        this.segundoNumero = segundoNumero;
    }

    @Override
    public String toString() {
        return "CalculadoraOTCP{" +
                "primerNumero=" + primerNumero +
                ", segundoNumero=" + segundoNumero +
                '}';
    }
}
