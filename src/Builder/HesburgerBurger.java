package Builder;

import Builder.burgerOsat.BurgerOsa;


import java.util.ArrayList;
import java.util.List;

public class HesburgerBurger {
    private List<BurgerOsa> osat;

    public HesburgerBurger(){
        this.osat = new ArrayList<>();
    }

    public void setBun(BurgerOsa bun) {
        osat.add(bun);
    }

    public void setMayo(BurgerOsa mayo) {
        osat.add(mayo);
    }

    public void setPatty(BurgerOsa patty) {
        osat.add(patty);
    }

    public void setSallad(BurgerOsa sallad) {
        osat.add(sallad);
    }

    public void setPickles(BurgerOsa pickles) {
        osat.add(pickles);
    }

    @Override
    public String toString() {
        String s = "HesburgerBurger: ";
        for (BurgerOsa osa : osat) {
            s += osa.toString() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        return s;
    }

}
