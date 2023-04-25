package Facade;

public class Memory {

    private char[] memory = new char[512];

    public Memory(){
    }

    public void Load(long position, char[] data) {
        for (int i = (int)position; i < (position + data.length); i++) {
            memory[i] = data[i];
        }
        System.out.println("load complete.");
    }
}
