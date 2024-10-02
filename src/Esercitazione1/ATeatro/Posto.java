package Esercitazione1.ATeatro;

public class Posto {
    private boolean occupato;
    private int idSpettatore;

    public Posto(){
        occupato = false;
        idSpettatore = -1;
    }

    public boolean getOccupato(){
        return occupato;
    }

    public void setOccupato(boolean status){
        occupato = status;
    }

    public int getIdSpettatore(){
        return idSpettatore;
    }

    public void setIdSpettatore(int id){
        idSpettatore = id;
    }
}
