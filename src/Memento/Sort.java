package Memento;

public class Sort {
    public Arvaaja[] bubblesort(Arvaaja[] arvaajat){
        Arvaaja[] arvaajat2 = arvaajat;
        int len = arvaajat.length;
        Arvaaja temp = null;
        for(int i=0; i < len; i++){
            for(int j=1; j < (len-i); j++){
                if(arvaajat2[j-1].getArvaukset() > arvaajat2[j].getArvaukset()){
                    temp = arvaajat2[j-1];
                    arvaajat2[j-1] = arvaajat2[j];
                    arvaajat2[j] = temp;
                }

            }
        }
        return arvaajat2;
    }
}
