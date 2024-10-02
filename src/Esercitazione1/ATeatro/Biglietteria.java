package Esercitazione1.ATeatro;

public class Biglietteria {
    private final Cinema cinema;

    public Biglietteria(Cinema cinema) {
        this.cinema = cinema;
    }

    public synchronized void acquistaBiglietto(int groupID) {
        boolean ris = trovaPostoLibero(groupID);
        /*if (ris) {
            System.out.println("Posto prenotato con successo.");
        } else {
            System.out.println("Nessun posto libero disponibile.");
        }*/
    }

    private boolean trovaPostoLibero(int gID) {
        // Ottieni le dimensioni della matrice
        int righe = cinema.getNFile();
        int colonne = cinema.getNPosti();

        // Definisci i possibili movimenti in termini di (dr, dc)
        // (destra, giù, sinistra, su)
        int[][] movimenti = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        // Iniziamo dal centro
        int r = righe / 2;
        int c = colonne / 2;

        // La direzione iniziale è destra
        int direzione = 0;

        // Conta i passi
        int passiDaFare = 1;

        // Numero totale di posti e posti controllati
        int totaleElementi = righe * colonne;
        int postiControllati = 0;

        boolean ris = false;

        while (totaleElementi > 0 && !ris) {

            for (int ripeti = 0; ripeti < 2; ripeti++) {
                for (int passi = 0; passi < passiDaFare; passi++) {

                    if (r >= 0 && r < righe && c >= 0 && c < colonne) {
                        postiControllati++;

                        if (cinema.takePosto(r, c, gID)) {
                            ris = true;
                            break;
                        }

                        totaleElementi--;

                        if (totaleElementi <= 0) {
                            break;
                        }
                    }

                    int[] movimento = movimenti[direzione];
                    r += movimento[0];
                    c += movimento[1];


                }

                direzione = (direzione + 1) % 4;
            }


            passiDaFare++;
        }

        return ris;
    }
}
