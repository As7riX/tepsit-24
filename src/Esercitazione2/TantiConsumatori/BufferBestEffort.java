package Esercitazione2.TantiConsumatori;

import java.util.ArrayList;
import java.util.List;

public class BufferBestEffort extends Buffer{

    private int lostDataCount;

    public BufferBestEffort(int maxSize) {
        super(maxSize);
        lostDataCount = 0;
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void put(int number) throws InterruptedException {

        // Attesa se il buffer è pieno
        if (list.size() == maxSize) {
            lostDataCount++;
        }
        else {
            list.add(number);
            notifyAll();
        }
    }

    public int getLostDataCount() {
        return lostDataCount;
    }
}
