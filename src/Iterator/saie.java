package Iterator;

import java.util.Iterator;
import java.util.List;

public class saie extends Thread{
    private boolean stop = false;

    Iterator<Integer> iterator;
    List<Integer> list;
    public saie(List<Integer> list, Iterator<Integer> iterator){
        this.list = list;
        this.iterator = iterator;
    }

    public void run(){
        while(!stop){
            while(iterator.hasNext()){
                System.out.println(iterator.next());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            stopRun();
        }
    }


    public void stopRun(){
        stop = true;
    }
}
