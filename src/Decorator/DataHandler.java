package Decorator;

public interface DataHandler {
    public void writeToFile(String file, String data);
    public String readFromFile(String file);

    public String getDescription();
}
