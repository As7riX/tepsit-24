package Esercitazione1.ATeatro;

public class Cinema {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    // Mappa posti
    private boolean[][] posti;

    // Numero di posti disponibili
    private int postiDisponibili;

    //costruttore
    public Cinema(int file, int postiPerFila) {

        //creazione e reset posti
        posti = new boolean[file][postiPerFila];
        for (int i = 0; i < file; i++)
            for (int j = 0; j < postiPerFila; j++)
                posti[i][j] = false;

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
        return posti[fila][n];
    }

    public boolean takePosto(int fila, int n){
        boolean r = false;

        if(!posti[fila][n]){
            posti[fila][n] = true;
            postiDisponibili--;
            r = true;
        }

        return r;
    }

    public boolean releasePosto(int fila, int n){
        boolean r = false;

        if (posti[fila][n]){
            posti[fila][n] = false;
            postiDisponibili++;
            r = true;
        }

        return r;
    }

    // Restituisce il numero di posti disponibili
    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    //stampa la disposizione del cinema
    public void printPosti(){
        System.out.println( ANSI_RESET + "Mappa posti cinema [Liberi: " + ANSI_GREEN + postiDisponibili + ANSI_RESET + " - Occupati: " + ANSI_RED + ((getNFile() * getNPosti()) - postiDisponibili) + ANSI_RESET + "]");

        for (int i = 0; i < getNFile(); i++) {
            for (int j = 0; j < getNPosti(); j++) {
                if (posti[i][j]) System.out.print(ANSI_RED + "☺ ");
                else             System.out.print(ANSI_GREEN + "□ ");
            }

            System.out.println(ANSI_RESET);
        }
    }
}
