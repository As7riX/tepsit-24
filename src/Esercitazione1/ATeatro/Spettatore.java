package Esercitazione1.ATeatro;

import java.util.Random;

public class Spettatore extends Thread {
    private final Biglietteria biglietteria;
    private final int groupID;

    public Spettatore(Biglietteria biglietteria, int groupID) {
        this.biglietteria = biglietteria;
        this.groupID = groupID;
    }

    @Override
    public void run() {
        Random random = new Random();
        int r = random.nextInt(150);

        for (int i = 0; i < r; i++) {
            biglietteria.acquistaBiglietto(groupID);
        }

    }
}

