package Observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClockTimer clock = new ClockTimer();
        clock.addObserver(new DigitalClock());

        String string;
        Thread thread = new Thread(clock);
        System.out.println("Type anything to start timer and type \"s\" to stop");
        string = scanner.nextLine();
        if(!string.toLowerCase().equals("s")){
            thread.start();
        }
        while (!string.toLowerCase().equals("s")){
            string = scanner.nextLine();
        }

        clock.stopRun();

    }
}
