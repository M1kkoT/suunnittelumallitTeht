package Facade;

public class HardDrive {
    char[] data = new char[1024];

    public HardDrive(){
        for (int i = 0; i < 1024; i++) {
            data[i] = (char) (i + 'O');
        }
    }
    public char[] Read(long lba, int size) {
        char[] bootData = new char[size];

        for(int i = (int)lba; i < (lba + size); i++){
            System.out.println("reading boot sector information: " + String.valueOf(data[i]));
            bootData[i] = data[i];
        }
        return bootData;
    }
}
