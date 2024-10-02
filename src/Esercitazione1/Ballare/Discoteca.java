package Esercitazione1.Ballare;

public class Discoteca {

    private final int capacita;

    private int[] piste;


    public Discoteca(int maxCap, int nPiste){
        capacita = maxCap;
        piste = new int[nPiste];

        for (int i = 0; i < nPiste; i++){
            piste[i] = 0;
        }
    }



    public int getPersone(int nPista){
        return piste[--nPista];
    }

    public int getNPiste(){
        return piste.length;
    }

    public synchronized boolean addPersona(int n, int nPista){
        boolean ris = false;

        if (capacita != -1) {
            if (piste[nPista-1] + n <= capacita) {
                piste[nPista-1] = piste[nPista-1] + n;
                ris = true;
            }
        }else {
            piste[nPista-1] += n;
            ris = true;
        }

        return ris;
    }

    public synchronized boolean removePersona(int n, int nPista){
        boolean ris = false;

        if (piste[nPista-1] - n >= 0){
            piste[nPista-1] = piste[nPista-1] - n;
            ris = true;
        }

        return ris;
    }



}
