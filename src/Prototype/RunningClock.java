package Prototype;

public class RunningClock extends Clock implements Runnable{

    private boolean stop = false;

    public RunningClock(String name, int h, int min, int s) {
        super(name, h, min, s);
    }

    public void run(){
        while (!stop){
            try{
                System.out.println(getTime());
                super.tic();
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void stopClock(){
        stop = true;
    }
}
