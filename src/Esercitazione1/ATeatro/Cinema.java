package Esercitazione1.ATeatro;

import java.util.HashMap;
import java.util.Map;

public class Cinema {

    public static final String ANSI_RESET = "\u001B[0m";

    HashMap<Integer, String> colori = new HashMap<Integer, String>(){{
        put(0, "\u001B[31m");
        put(1, "\u001B[32m");
        put(2, "\u001B[33m");
        put(3, "\u001B[34m");
        put(4, "\u001B[35m");
        put(5, "\u001B[36m");
        put(6, "\u001B[37m");
    }
    };

    // Mappa posti
    private Posto[][] posti;

    // Numero di posti disponibili
    private int postiDisponibili;

    //costruttore
    public Cinema(int file, int postiPerFila) {

        //creazione e reset posti
        posti = new Posto[file][postiPerFila];
        for (int i = 0; i < file ; i++)
            for (int j = 0; j < postiPerFila; j++)
                posti[i][j] = new Posto();

        postiDisponibili = file * postiPerFila;
    }

    //get numero file
    public int getNFile(){
        return posti.length;
    }

    //get numero posti per fila
    public int getNPosti(){
        return posti[0].length;
    }

    //get status posto
    public boolean getStatusPosto(int fila, int n){
        return posti[fila][n].getOccupato();
    }

    public boolean takePosto(int fila, int n, int gID){
        boolean r = false;

        if(!posti[fila][n].getOccupato()){
            posti[fila][n].setOccupato(true);
            posti[fila][n].setIdSpettatore(gID);
            postiDisponibili--;
            r = true;
        }

        return r;
    }

    public boolean releasePosto(int fila, int n){
        boolean r = false;

        if (posti[fila][n].getOccupato()){
            posti[fila][n].setOccupato(false);
            postiDisponibili++;
            r = true;
        }

        return r;
    }

    //stampa la disposizione del cinema
    public void printPosti(){
        System.out.println( ANSI_RESET + "Mappa posti cinema [Liberi: " + colori.get(1) + postiDisponibili + ANSI_RESET + " - Occupati: " + colori.get(0) + ((getNFile() * getNPosti()) - postiDisponibili) + ANSI_RESET + "]");

        for (int i = 0; i < getNFile(); i++) {
            for (int j = 0; j < getNPosti(); j++) {
                if (posti[i][j].getOccupato())
                    System.out.print(colori.get(posti[i][j].getIdSpettatore()) + "☺ ");
                else  System.out.print(colori.get(6) + "□ ");
            }

            System.out.println(ANSI_RESET);
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(colori.get(i) + "Thread " + i + ANSI_RESET + "  ");
        }

        System.out.println();
    }
}
