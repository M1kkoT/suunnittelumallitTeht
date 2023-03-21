package Memento;

public class Main  {
    public static void main(String[] args) {
        Arvuuttaja arvuuttaja = new Arvuuttaja();

        Arvaaja[] arvaajat = new Arvaaja[5];

        for (int i = 0; i < 5; i++) {
            Arvaaja a = new Arvaaja(arvuuttaja.liityPeliin(), arvuuttaja);
            a.setNimi("arvaaja" + i);
            arvaajat[i] = a;
        }

        for (int i = 0; i < 5; i++) {
            arvaajat[i].start();
        }

        try {
            for (Arvaaja a : arvaajat) {
                a.join();
            }
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        Sort sort = new Sort();
        Arvaaja[] a2 = sort.bubblesort(arvaajat);

        System.out.println("Peli loppui");
        for (int i = 0; i < a2.length; i++){
            System.out.println(a2[i].getNimi() + " oli numero " + (i + 1) + ", arvauksia: " + a2[i].getArvaukset());
        }
    }


}
