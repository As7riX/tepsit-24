package Esercitazione1.ThreadAccoppiati;

public class Counter {

    private int n;

    Counter(int start){
        n = start;
    }

    public synchronized int add(){
        n++;
        return n;
    }

}
