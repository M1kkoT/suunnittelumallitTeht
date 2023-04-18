package Prototype;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) {
        RunningClock clock1 = new RunningClock("Kello1",4, 59, 58);

        RunningClock clock2 = (RunningClock) clock1.clone();

        clock2.setTime(12, 59, 55);
        clock2.giveName("kello2");

        Thread startedClock1 = new Thread(clock1);
        Thread startedClock2 = new Thread(clock2);

        startedClock1.start();
        startedClock2.start();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clock1.stopClock();
        clock2.stopClock();
    }
}
