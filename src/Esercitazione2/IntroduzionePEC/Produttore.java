package Esercitazione2.IntroduzionePEC;

import java.util.Random;

public class Produttore implements Runnable {
    private final Buffer buffer;
    private final Random random;

    public Produttore(Buffer buffer) {
        this.buffer = buffer;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = random.nextInt(1024);

                int delay = random.nextInt(901) + 100;

                buffer.put(number);

                //System.out.println("Prodotto: " + number);

                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

