package Esercitazione1.ThreadAccoppiati;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci numero thread: ");
        int t = input.nextInt();

        System.out.println("Inserisci numero massimo: ");
        int nmax = input.nextInt();

        Counter[] counter = new Counter[t/2];
        Thread[][] threads = new Thread[t/2][2];


        //inizializzazione thread e counter
        for (int i = 0; i < t/2; i++) {
            counter[i] = new Counter(0);
            threads[i][0] = new Thread(new TCounter(counter[i], nmax, i));
            threads[i][1] = new Thread(new TCounter(counter[i], nmax, i));
        }

        //starting thread
        for (Thread td[]: threads){
            td[0].start();
            td[1].start();
        }

    }

}

