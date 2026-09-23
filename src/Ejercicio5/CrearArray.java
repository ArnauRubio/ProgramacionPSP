package Ejercicio5;

import java.util.Random;

public class CrearArray implements Runnable{
       @Override
    public void run() {
        int[] n = new int[2000];
        Random r = new Random(11);

        for (int i = 0; i < n.length; i++) {
           n[i] = r.nextInt(11);
        }


    }
}
