package Esercitazione1.ATeatro;

public class Spettatore extends Thread {
    private final Biglietteria biglietteria;

    public Spettatore(Biglietteria biglietteria) {
        this.biglietteria = biglietteria;
    }

    @Override
    public void run() {
        biglietteria.acquistaBiglietto();
    }
}

