package Esercitazione2.TantiConsumatori;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di consumatori: ");
        int C = scanner.nextInt();

        Buffer buffer = new Buffer();

        Thread produttore = new Thread(new Produttore(buffer));
        produttore.start();

        Thread[] consumatori = new Thread[C];
        for (int i = 0; i < C; i++) {
            consumatori[i] = new Thread(new Consumatore(buffer));
            consumatori[i].start();
        }

    }


}
