package Esercitazione2.TantiConsumatori;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private List<Integer> buffer;
    
    public Buffer(){
        buffer = new ArrayList<Integer>();
    }

    public void push(int n){
        buffer.add(n);
    }

    public synchronized int pop(){
        int n = -1025;
        if (!buffer.isEmpty())
            n = (Integer)buffer.remove(0);

        return n;
    }


}
