package composite;

import javax.naming.Name;

public class Main {
    public static void main(String[] args) {

        ItietokoneenOsa kotelo = new Kotelo(174.90, "Fractal Design North");
        ItietokoneenOsa emolevy = new Emolevy(154.90, "Asus TUF GAMING B550-PLUS");
        emolevy.addKomponentti(new Kovalevy(174.90, "Samsung 2TB 870 QVO"));
        emolevy.addKomponentti(new Muisti(104.90, "Kingston 32GB FURY Beast"));
        emolevy.addKomponentti(new Näytönohjain(10831.00, "PNY NVIDIA RTX 6000 Ada Generation, 48GB GDDR6"));
        emolevy.addKomponentti(new Prosessori(379.90, "AMD RYZEN 7 5800X3D"));

        kotelo.addKomponentti(emolevy);

        System.out.println(kotelo.getHinta());


    }
}
