package Esercitazione2.IntroduzionePEC;

import java.util.Random;

public class ConsumatoreTime implements Runnable{
    private final Buffer buffer;
    private int pari;
    private int dispari;

    private int count;


    public ConsumatoreTime(Buffer buffer) {
        this.buffer = buffer;
        pari = dispari = count = 0;
    }

    @Override
    public void run() {
        int[] delays = {200, 400, 600, 800, 1000};
        long startTime = System.currentTimeMillis();

        try {
            while (count < 5000) {
                int number = buffer.get();

                if (number % 2 == 0) {
                    pari++;
                } else {
                    dispari++;
                }

                System.out.println("Pari: " + pari + " - Dispari: " + dispari);
                Thread.sleep(delays[new Random().nextInt(delays.length)]);
                count++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Consumatore ha impiegato: " + (endTime - startTime) + " ms");
        }
    }
}
