package composite;

public class Kovalevy implements ItietokoneenOsa{
    private double hinta;

    private String nimi;

    public Kovalevy(double hinta, String nimi){
        this.hinta = hinta;
        this.nimi = nimi;
    }

    @Override
    public double getHinta() {
        return this.hinta;
    }


    @Override
    public void addKomponentti(ItietokoneenOsa komponentti) {
        throw new RuntimeException("Ei voi lisätä komponentteja peruskomponentteihin");
    }


}
