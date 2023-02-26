package Decorator;

import java.io.*;

public class ConcreteDataHandler implements DataHandler {

    @Override
    public void writeToFile(String fileName, String data) {


        try (FileWriter tiedosto = new FileWriter(String.format("src/Decorator/%s.txt", fileName), true);
             BufferedWriter bw = new BufferedWriter(tiedosto))
        {
            bw.write(data);
            bw.newLine();

        }
        catch (IOException e) {
            System.err.println("exception in file handling");
        }


    }

    @Override
    public String readFromFile(String fileName) {

        String data = "";

        try (FileReader tiedosto = new FileReader(String.format("src/Decorator/%s.txt", fileName));
             BufferedReader br = new BufferedReader(tiedosto))
        {
            String rivi = br.readLine();
            while (rivi != null) {
                data += ("\n" + rivi);
                rivi = br.readLine();
            }

        }
        catch (IOException e) {
            System.err.println("Poikkeus tiedoston käsittelyssä");
        }

        return data;
    }

    @Override
    public String getDescription() {
        return "reads and writes data to and from a file.";
    }


}
