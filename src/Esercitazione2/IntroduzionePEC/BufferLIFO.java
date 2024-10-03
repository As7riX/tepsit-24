package Esercitazione2.IntroduzionePEC;

import java.util.ArrayList;
import java.util.List;

public class BufferLIFO {
    private final List<Integer> list;
    private final int maxSize;

    public BufferLIFO(int maxSize) {
        list = new ArrayList<Integer>();
        this.maxSize = maxSize;
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void put(int number) throws InterruptedException {

        // Attesa se il buffer è pieno
        while (list.size() == maxSize) {
            System.out.println("Buffer Pieno");
            wait();
        }

        list.add(number);
        notifyAll();
    }

    // Metodo per consumare un numero dal buffer
    public synchronized int get() throws InterruptedException {
        // Attesa se il buffer è vuoto
        while (list.isEmpty()) {
            System.out.println("Buffer Vuoto");
            wait();
        }

        int number = list.removeLast();
        notifyAll();
        return number;
    }
}
