package Chain_of_responsibility;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        Director director = new Director();
        CEO ceo = new CEO();
        manager.setSuccessor(director);
        director.setSuccessor(ceo);
        while (true) {
            System.out.println("Enter the current salary");System.out.print(">");
            double current = Double.parseDouble(sc.nextLine());
            System.out.println("Enter the asked salary to check who should approve your expenditure.");System.out.print(">");
            double asked = Double.parseDouble(sc.nextLine());
            manager.approveRaise(new RaiseRequest(current, asked));
        }
        /*
        try {
            while (true) {
                System.out.println("Enter the current salary");System.out.print(">");
                double current = Double.parseDouble(sc.nextLine());
                System.out.println("Enter the asked salary to check who should approve your expenditure.");System.out.print(">");
                double asked = Double.parseDouble(sc.nextLine());
                manager.approveRaise(new RaiseRequest(current, asked));
            }
        } catch(Exception e) {
            System.out.println(e);
        }*/
    }
}
