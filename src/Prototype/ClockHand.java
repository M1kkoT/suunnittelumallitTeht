package Prototype;

public class ClockHand implements Cloneable{
    private int time;

    public void setTime(int time){
        this.time = time;
    }

    public void tic(){
        this.time ++;
    }

    public int getTime(){
        return time;
    }

    public Object clone(){
        ClockHand h = null;
        try{
            h = (ClockHand) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return h;
    }
}
