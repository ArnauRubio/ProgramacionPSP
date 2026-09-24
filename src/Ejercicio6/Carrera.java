package Ejercicio6;

import java.util.Random;

import static java.lang.Math.random;

public class Carrera implements Runnable{
    Atletas atletas;
    @Override
    public void run() {
        int avanze;
        double x = random();

        for (int i = 0; i <= 50; i++) {
          avanze = (int) (x * 3 + 1);
          i = avanze + 1;

            System.out.println(this.atletas + "ha corrido..." + avanze);
            System.out.println(this.atletas + "ha corrido..." + avanze);
            System.out.println(this.atletas + "ha corrido..." + avanze);

            if (i >= 50){
                System.out.println(this.atletas + "Ha acabado la carrera!");
            }
        }
    }
}
