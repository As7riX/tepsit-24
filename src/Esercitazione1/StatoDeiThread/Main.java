package Esercitazione1.StatoDeiThread;

/*

Stato dei Thread

Fare un programma che chiede all’utente due valori T ed N, dove T indica quanti Thread creare
ed ogni Thread conta i valori (SENZA STAMPARE) da 0 fino ad X dove X è un numero compreso
tra 0 e N.

Ogni Thread dopo che ha stampato un valore aspetta 120ms

Il Thread principale stampa periodicamente (al massimo una volta al secondo) lo stato dei
Thread e per i Thread attivi stampa il valore a cui è arrivato a contare, mentre per quelli terminati
stampa “COMPLETATO”, quando tutti i Thread hanno raggiunto il loro valore X il programma
deve stampare “TUTTI I THREAD COMPLETATI” e terminare

Suggerimenti
Per vedere se un Thread è attivo esiste il metodo isAlive(), mentre per aspettare il
completamento di un Thread esiste il metodo join()

 */

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi i valori T ed N all'utente
        System.out.print("Inserisci il numero di Thread (T): ");
        int T = scanner.nextInt();

        System.out.print("Inserisci il valore massimo (N): ");
        int N = scanner.nextInt();

        Random random = new Random();
        ThreadCounter[] tc = new ThreadCounter[T];
        Thread[] threads = new Thread[T];

        // Crea T thread e ciascuno conta fino a un valore casuale tra 0 e N
        for (int i = 0; i < T; i++) {
            tc[i] = new ThreadCounter(random.nextInt(N));
            threads[i] = new Thread(tc[i]);
        }

        for (int i = 0; i < T; i++) {
            threads[i].start();
        }

        boolean allCompleted = false;

        // Il thread principale controlla lo stato dei thread periodicamente
        while (!allCompleted) {
            allCompleted = true;

            System.out.println("==================================================");

            // Stampa lo stato dei thread
            for (int i = 0; i < T; i++) {
                if (threads[i].isAlive()) {
                    System.out.println("Thread " + (i + 1) + " sta contando: " + tc[i].getCurrentCount());
                    allCompleted = false; // Se uno dei thread è ancora attivo, non sono tutti completati
                } else {
                    System.out.println("Thread " + (i + 1) + " COMPLETATO");
                }
            }

            System.out.println("==================================================");


            // Aspetta 1 secondo prima di controllare nuovamente
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("TUTTI I THREAD COMPLETATI");
    }
}