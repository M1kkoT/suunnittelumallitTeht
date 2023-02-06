package Singleton;

public class HondaRekkaAuto extends RekkaAuto{
    private String merkki = "Honda";

    @Override
    public String getMerkki() {
        return merkki;
    }

    @Override
    public void tellMerkki() {
        System.out.println("Rekka-auton merkki on " + merkki);
    }
}
