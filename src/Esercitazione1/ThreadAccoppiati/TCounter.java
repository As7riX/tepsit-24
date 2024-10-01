package Esercitazione1.ThreadAccoppiati;

public class TCounter implements Runnable {

    Counter c;
    int max, groupId;

    TCounter(Counter c, int max, int groupId){
        this.c = c;
        this.max = max;
        this.groupId = groupId;
    }

    @Override
    public void run() {
        int n = c.add();
        while (n <= max) {
            System.out.println("Thread n " + Thread.currentThread().threadId() + " gruppo " + groupId + " - " + n);
            n = c.add();
        }
    }
}
