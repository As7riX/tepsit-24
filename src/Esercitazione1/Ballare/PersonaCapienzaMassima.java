package Esercitazione1.Ballare;

import java.util.Random;

public class PersonaCapienzaMassima extends Thread{
    private Discoteca disco;
    private int persone;

    public PersonaCapienzaMassima(Discoteca disco){
        Random random = new Random();
        this.disco = disco;
        persone = random.nextInt(30);
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true){
            disco.addPersona(persone, 1);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            disco.removePersona(persone, 1);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
