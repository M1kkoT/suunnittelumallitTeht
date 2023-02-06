package composite;

import java.util.ArrayList;
import java.util.List;

public class Kotelo implements ItietokoneenOsa{

    private List<ItietokoneenOsa> osat;
    private double hinta;

    private String nimi;

    public Kotelo(double hinta, String nimi){
        this.hinta = hinta;
        this.nimi = nimi;
        osat = new ArrayList<>();
    }

    @Override
    public double getHinta() {
        double kokoHinta = hinta;
        if(osat.isEmpty()){
            return kokoHinta;
        }
        for(ItietokoneenOsa osa : osat){
            kokoHinta += osa.getHinta();
        }
        return kokoHinta;
    }


    @Override
    public void addKomponentti(ItietokoneenOsa komponentti) {
        osat.add(komponentti);

    }
}
