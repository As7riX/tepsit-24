package Esercitazione2.IntroduzionePEC;

public class Consumatore implements Runnable {
    private final Buffer buffer;
    private int pari;
    private int dispari;

    public Consumatore(Buffer buffer) {
        this.buffer = buffer;
        pari = dispari = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = buffer.get();

                if (number % 2 == 0) {
                    pari++;
                } else {
                    dispari++;
                }

                System.out.println("Pari: " + pari + " - Dispari: " + dispari);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

