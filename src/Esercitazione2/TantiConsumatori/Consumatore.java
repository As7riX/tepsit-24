package Esercitazione2.TantiConsumatori;

public class Consumatore extends Thread {

    private Buffer buffer;

    public Consumatore(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {

        int[] values = new int[]{0, 0, 0, 0, 0};
        int pos = 0;

        while (true){
            int n = buffer.pop();

            //attesa valore in buffer
            while (n == -1025) n = buffer.pop();

            if (n > 0) {
                values[pos] = n;
                pos = (pos + 1) % 5;
            }

            int media = (values[0] + values[1] + values[2] + values[3] + values[4])/5;

            System.out.println("Thread " + Thread.currentThread().threadId() + " ha la media di: " + media );

            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
