package com.company;

public class Dado implements Runnable{

    Marcador marcador = new Marcador();

    public Dado(Marcador marcador) {
        this.marcador = marcador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            marcador.increment();
        }
    }
}
