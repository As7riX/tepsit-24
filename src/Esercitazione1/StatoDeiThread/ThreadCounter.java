package Esercitazione1.StatoDeiThread;

public class ThreadCounter implements Runnable {
    private int max;
    private int counter;

    public ThreadCounter(int max) {
        this.max = max;
        counter = 0;
    }

    public int getCurrentCount() {
        return counter;
    }

    @Override
    public void run() {
        try {
            while (counter < max) {
                counter++;
                Thread.sleep(120);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
