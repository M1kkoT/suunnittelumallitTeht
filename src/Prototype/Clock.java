package Prototype;

public class Clock implements Cloneable {
    private String name;
    private ClockHand hourPointer;
    private ClockHand minPointer;
    private ClockHand secPointer;




    public Clock(String name, int h, int min, int s){
        this.name = name;
        ClockHand hand = new ClockHand();
        ClockHand handMin = (ClockHand) hand.clone();
        ClockHand handSec = (ClockHand) hand.clone();
        hand.setTime(h);
        handMin.setTime(min);
        handSec.setTime(s);
        this.hourPointer = hand;
        this.minPointer = handMin;
        this.secPointer = handSec;
    }

    public void giveName(String name){
        this.name = name;
    }

    public void setTime(int h, int min, int s){

        this.hourPointer.setTime(h);
        this.minPointer.setTime(min);
        this.secPointer.setTime(s);
    }

    public String getTime(){
        String s = "";
        s += (name +  ": Tunti: " + hourPointer.getTime() + " Min: " + minPointer.getTime() + " Sec: " + secPointer.getTime());
        return s;
    }

    //tics one second forward
    public void tic(){
        secPointer.tic();
        if(secPointer.getTime() >= 60){
            secPointer.setTime(0);
            minPointer.tic();
            if(minPointer.getTime() >= 60){
                minPointer.setTime(0);
                hourPointer.tic();
                if(hourPointer.getTime() > 12){
                    hourPointer.setTime(1);
                }
            }
        }
    }


    public Clock clone(){
        Clock clock = null;
        try{
            clock = (Clock) super.clone();
            clock.hourPointer = (ClockHand) hourPointer.clone();
            clock.minPointer = (ClockHand) minPointer.clone();
            clock.secPointer = (ClockHand) secPointer.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clock;
    }
}
