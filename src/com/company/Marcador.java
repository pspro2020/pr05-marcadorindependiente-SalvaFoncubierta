package com.company;

import java.util.Random;

public class Marcador {
    private int[] marcador = new int[6];
    private Object[] vigilante = new Object[] {new Object(), new Object(), new Object(),
                                               new Object(), new Object(), new Object()};
    private Random r = new Random();
    private int tirada;

    public void increment(){
        tirada = r.nextInt(6);
        synchronized (vigilante [tirada]){
            marcador[tirada]++;
        }

    }

    public int[] getMarcador() {
        return marcador;
    }
}
