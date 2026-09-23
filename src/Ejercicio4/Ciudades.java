package Ejercicio4;

public class Ciudades implements Runnable{
    @Override
    public void run() {
        String[] c;
        c = new String[]{"Albacete", "Alicante", "Barcelona", "Badalona", "Badajoz", "Bilbao", "Cadiz", "Cartagena", "Ceuta", "Cordoba", "Guadalajara", "Guernika", "Huelva", "Jaen", "Jerez", "Jijon", "La Rioja", "Legutio", "Madrid", "Mayorca"};

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
