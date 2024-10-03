package Esercitazione2.IntroduzionePEC;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        Thread produttore = new Thread(new ProduttoreTime(buffer));
        Thread consumatore = new Thread(new ConsumatoreTime(buffer));

        produttore.start();
        consumatore.start();
    }
}
