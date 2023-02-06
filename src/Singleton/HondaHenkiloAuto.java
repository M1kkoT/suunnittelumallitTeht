package Singleton;

public class HondaHenkiloAuto extends HenkiloAuto{

    private String merkki = "Honda";
    @Override
    public String getMerkki() {
        return merkki;
    }

    @Override
    public void tellMerkki() {
        System.out.println("Henkilöauton merkki on " + merkki);
    }


}
