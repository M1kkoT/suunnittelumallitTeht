package Memento;

public class Arvuuttaja {



    public Object liityPeliin(){
        int random = (int) (Math.random() * (10 + 1));
        return new Memento(random);
    }

    public boolean arvaa(Object obj, int arvaus){
        Memento memento = (Memento) obj;
        if(arvaus == (memento.getLuku())){
            System.out.println("arvaus: " + arvaus);
            System.out.println("Arvaus oikein!");
            return true;
        }else{
            System.out.println("arvaus: " + arvaus);
            System.out.println("Arvaus väärin");
            return false;
        }
    }


    private class Memento{
        private int luku;
        public Memento(int luku){
            this.luku = luku;
        }
        public int getLuku(){
            return luku;
        }
    }
}
