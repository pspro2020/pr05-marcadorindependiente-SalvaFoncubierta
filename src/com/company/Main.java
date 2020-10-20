package com.company;

public class Main {

    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 3;
        int total = 0;
        Marcador marcador = new Marcador();
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(new Dado(marcador));
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].start();
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido");
            }
        }

        for (int i = 0; i < marcador.getMarcador().length; i++) {
            System.out.printf("Número %d: %d veces \n", i+1, marcador.getMarcador()[i]);
        }

        System.out.printf("Total de veces: ");

        for (int i = 0; i < marcador.getMarcador().length; i++) {
            total += marcador.getMarcador()[i];
            if (i == 0){
                System.out.printf("%d ", marcador.getMarcador()[i]);
            } else if(i == marcador.getMarcador().length - 1){
                System.out.printf("+ %d = %d", marcador.getMarcador()[i], total);
            } else {
                System.out.printf("+ %d ", marcador.getMarcador()[i]);
            }
        }

    }
}
