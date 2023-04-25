package Facade;

public class CPU {
    public void Freeze() {
        System.out.println("cpu freeze");
    }

    public void Jump(long position) {
        System.out.println("cpu jumped to position " + position);
    }

    public void Execute() {
        System.out.println("execute boot...");
        System.out.println("boot successfull.");
    }
}
