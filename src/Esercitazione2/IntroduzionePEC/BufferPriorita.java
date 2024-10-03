package Esercitazione2.IntroduzionePEC;

import java.util.ArrayList;
import java.util.List;

public class BufferPriorita {
    private final List<Integer> listPrimi;
    private final List<Integer> listNormali;
    private final int maxSize;

    public BufferPriorita(int maxSize) {
        listPrimi = new ArrayList<Integer>();
        listNormali = new ArrayList<Integer>();
        this.maxSize = maxSize;
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void put(int number) throws InterruptedException {

        // Attesa se il buffer è pieno
        while (listNormali.size() + listPrimi.size() == maxSize) {
            System.out.println("Buffer Pieno");
            wait();
        }

        if (nPrimo(number)){
            listPrimi.add(number);
        }else{
            listNormali.add(number);
        }

        notifyAll();
    }

    // Metodo per consumare un numero dal buffer
    public synchronized int get() throws InterruptedException {
        // Attesa se il buffer è vuoto
        while (listNormali.isEmpty() && listPrimi.isEmpty()) {
            System.out.println("Buffer Vuoto");
            wait();
        }

        int number;

        if (!listPrimi.isEmpty()){
            number = listPrimi.removeFirst();
        }else{
            number = listNormali.removeFirst();
        }

        notifyAll();
        return number;
    }

    private boolean nPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
