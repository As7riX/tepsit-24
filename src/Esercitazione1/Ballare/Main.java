package Esercitazione1.Ballare;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di esercizio (1- Singolo, 2- Gruppi, 3- Multi-Stanza, 4- Capienza Massima): ");
        int S = scanner.nextInt();

        // Chiedi i valori T ed N all'utente
        System.out.print("Inserisci il numero di Thread (T): ");
        int T = scanner.nextInt();

        Discoteca disco;
        Thread[] threads = new Thread[T];
        int sleepTime;

        if (S == 1){
            disco = new Discoteca(-1, 1);

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new PersonaSingolo(disco);
                threads[i].start();
            }

            sleepTime = 1000;
        } else if (S == 2) {
            disco = new Discoteca(-1, 1);

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new PersonaGruppi(disco);
                threads[i].start();
            }

            sleepTime = 2000;
        } else if (S == 3) {
            disco = new Discoteca(-1, 4);

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new PersoneMultiStanza(disco);
                threads[i].start();
            }

            sleepTime = 500;
        } else if (S == 4){
            disco = new Discoteca(161, 1);

            sleepTime = 1000;
        }else {
            return;
        }


        while (true){
            if (disco.getNPiste() == 1)
                System.out.println("Persone nella discoteca: " + disco.getPersone(1));
            else{
                System.out.println("Persone nella discoteca: ");
                for (int i = 0; i < disco.getNPiste(); i++) {
                    System.out.println("Pista n° " + i + ": " + disco.getPersone(i+1));
                }
            }

            // Aspetta 1 secondo prima di controllare nuovamente
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
