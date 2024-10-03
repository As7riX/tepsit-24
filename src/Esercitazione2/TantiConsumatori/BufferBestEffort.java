package Esercitazione2.TantiConsumatori;

public class BufferBestEffort extends Buffer{

    private int lostDataCount;

    public BufferBestEffort(int maxSize) {
        super(maxSize);
        lostDataCount = 0;
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void put(int number){

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
