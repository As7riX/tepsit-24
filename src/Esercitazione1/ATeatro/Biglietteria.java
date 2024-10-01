package Esercitazione1.ATeatro;

public class Biglietteria {
    private final Cinema cinema;

    public Biglietteria(Cinema cinema) {
        this.cinema = cinema;
    }

    public synchronized void acquistaBiglietto() {
        boolean ris = trovaPostoLibero();
        if (ris) {
            System.out.println("Posto prenotato con successo.");
        } else {
            System.out.println("Nessun posto libero disponibile.");
        }
    }

    private boolean trovaPostoLibero() {
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
                    // Controlla se siamo dentro i limiti della matrice
                    if (r >= 0 && r < righe && c >= 0 && c < colonne) {
                        postiControllati++;  // Contiamo i posti visitati

                        // Se troviamo un posto libero (false), prenotiamo e usciamo
                        if (cinema.takePosto(r, c)) {
                            ris = true;
                            break;
                        }

                        // Diminuisci il numero totale di posti da controllare
                        totaleElementi--;

                        // Controllo per evitare un ciclo infinito
                        if (totaleElementi <= 0) {
                            break;
                        }
                    }

                    // Muoviti nella direzione attuale
                    int[] movimento = movimenti[direzione];
                    r += movimento[0];
                    c += movimento[1];


                }

                // Cambia direzione (cicla tra destra, giù, sinistra, su)
                direzione = (direzione + 1) % 4;
            }

            // Aumenta il numero di passi ogni due cambi di direzione
            passiDaFare++;
        }

        // Output di debug per visualizzare quanti posti sono stati controllati
        System.out.println("Posti controllati: " + postiControllati);
        System.out.println("Posti rimanenti: " + totaleElementi);

        return ris;
    }
}
