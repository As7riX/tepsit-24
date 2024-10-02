package Esercitazione1.Ballare;

import java.util.Random;

public class PersonaSingolo extends Thread{

    private Discoteca disco;


    public PersonaSingolo(Discoteca disco){
        this.disco = disco;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            disco.addPersona(1, 1);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            disco.removePersona(1, 1);
            try {
                sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
