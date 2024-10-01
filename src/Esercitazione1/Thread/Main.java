package Esercitazione1.Thread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci numero thread: ");
        int t = input.nextInt();

        System.out.println("Inserisci numero massimo: ");
        int nmax = input.nextInt();

        Counter counter = new Counter(0);
        Thread[] threads = new Thread[t];

        //inizializzazione thread
        for (int i = 0; i < threads.length; i++) {
            TCounter counter1 = new TCounter(counter, nmax);
            threads[i] = new Thread(counter1);
        }

        //starting thread
        for (Thread td: threads){
            td.start();
        }

    }

}

class TCounter implements Runnable {

    Counter c;
    int max;

    TCounter(Counter c, int max){
        this.c = c;
        this.max = max;
    }

    @Override
    public void run() {
        int n = c.add();

        while (n <= max) {
            System.out.println("Thread n: " + Thread.currentThread().threadId() + " - " + n);

            n = c.add();

        }
    }
}