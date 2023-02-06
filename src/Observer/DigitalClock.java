package Observer;

import java.util.Observable;
import java.util.Observer;

public class DigitalClock implements Observer {

    public DigitalClock(){}

    private void draw(Object arg){
        System.out.println(arg);
    }

    @Override
    public void update(Observable o, Object arg) {
        draw(arg);
    }
}
