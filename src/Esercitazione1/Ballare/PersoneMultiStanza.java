package Esercitazione1.Ballare;

import java.util.Random;

public class PersoneMultiStanza extends Thread{
    private Discoteca disco;
    private int persone;

    public PersoneMultiStanza(Discoteca disco){
        Random random = new Random();
        this.disco = disco;
        persone = random.nextInt(100);
    }

    @Override
    public void run() {
        Random random = new Random();

        int nPista = random.nextInt(4)+1;

        while (true){
            disco.addPersona(persone, nPista);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            disco.removePersona(persone, nPista);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nPista = random.nextInt(4)+1;
        }
    }
}
