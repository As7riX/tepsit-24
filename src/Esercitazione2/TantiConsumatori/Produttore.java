package Esercitazione2.TantiConsumatori;

import java.util.Random;

public class Produttore extends Thread{

    private Buffer buffer;

    public Produttore(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true){
            int n = random.nextInt(2048) - 1024;

            buffer.push(n);

            if (n > 0) {
                try {
                    sleep(n/100*50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
