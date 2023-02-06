package Observer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;


public class ClockTimer extends Observable implements Runnable{

    private volatile boolean stop = false;

    public void run(){
        while(!stop){
            setChanged();
            notifyObservers(getTime());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getTime(){
        long time = System.currentTimeMillis();
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
        Date fromMillis = new Date(time);
        String result = date.format(fromMillis);

        return result;
    }

    public void stopRun(){
        stop = true;
    }


}
