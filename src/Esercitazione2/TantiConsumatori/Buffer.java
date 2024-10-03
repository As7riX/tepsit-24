package Esercitazione2.TantiConsumatori;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Buffer {

    protected final List<Integer> list;
    protected final int maxSize;

    public Buffer(int maxSize) {
        list = new ArrayList<Integer>();
        this.maxSize = maxSize;
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void put(int number) throws InterruptedException {

        // Attesa se il buffer è pieno
        while (list.size() == maxSize) {
            //System.out.println("Buffer Pieno");
            wait();
        }

        list.add(number);
        notifyAll();
    }

    // Metodo per consumare un numero dal buffer
    public synchronized int get() throws InterruptedException {
        // Attesa se il buffer è vuoto
        while (list.isEmpty()) {
            //System.out.println("Buffer Vuoto");
            wait();
        }

        int number = list.removeFirst();
        notifyAll();
        return number;
    }


}
