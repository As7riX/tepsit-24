package Esercitazione2.IntroduzionePEC;

import java.util.Random;

public class ProduttoreTime implements Runnable{
    private final Buffer buffer;
    private final Random random;
    private int count;


    public ProduttoreTime(Buffer buffer) {
        this.buffer = buffer;
        random = new Random();
        count = 0;
    }

    @Override
    public void run() {

        int[] delays = {100, 250, 500, 1000};
        long startTime = System.currentTimeMillis();

        try {
            while (count < 5000) {
                int number = random.nextInt(1024);
                buffer.put(number);

                //System.out.println("Prodotto: " + number);

                Thread.sleep(delays[random.nextInt(delays.length)]);
                count++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Produttore ha impiegato: " + (endTime - startTime) + " ms");
        }
    }
}
