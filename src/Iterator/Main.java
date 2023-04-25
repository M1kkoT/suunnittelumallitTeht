package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }

        Iterator<Integer> it = arr.iterator();
        Iterator<Integer> it2 = arr.iterator();
        Iterator<Integer> it3 = arr.iterator();

        Thread saie1 = new saie(arr, it);
        Thread saie2 = new saie(arr, it2);


        saie1.start();
        saie2.start();


        // c kohta heittää erroria
        /*
        for(int i = 0; i < 10; i++){
            arr.add(i);
            arr.remove(i - 9);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        */
        try {
            saie1.join();
            saie2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        it3.forEachRemaining((num) -> System.out.println(num));


    }



}
