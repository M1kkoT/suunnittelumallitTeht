package Singleton;

public class Main {
    public static void main(String[] args) {
        AjoneuvoFactory factory = HondaAjoneuvoFactory.getInstance();

        Ajoneuvo henkiloauto = factory.makeHenkiloAuto();
        Ajoneuvo rekka = factory.makeRekkaAuto();

        henkiloauto.tellMerkki();
        rekka.tellMerkki();


    }
}
