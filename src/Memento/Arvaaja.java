package Memento;

public class Arvaaja extends Thread{

    private Object memento;

    private Arvuuttaja arvuuttaja;

    private int arvaukset = 0;

    private String nimi;

    private boolean stop = false;

    public Arvaaja(Object memento, Arvuuttaja arvuuttaja){
        this.memento = memento;
        this.arvuuttaja = arvuuttaja;
    }

    public int getArvaukset(){
        return arvaukset;
    }

    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    public String getNimi(){
        return nimi;
    }

    public void run(){
        while (!stop){
            try{
                int random = (int) (Math.random() * (10 + 1));
                boolean arvaus = arvuuttaja.arvaa(memento, random);
                arvaukset++;
                if(arvaus){
                    stop = true;
                }
                sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
    }
}
