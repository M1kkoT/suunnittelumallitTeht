package Builder;

import Builder.burgerOsat.*;

public class HesburgerBuilder implements BurgerBuilder{

    private HesburgerBurger burger;

    @Override
    public void createNewBurgerProduct() {
        this.burger = new HesburgerBurger();
    }

    @Override
    public void buildBun() {
        burger.setBun(new KokojyvaBun());
    }

    @Override
    public void buildMayonnaise() {
        burger.setMayo(new BellPepperMayo());
    }

    @Override
    public void buildPatty() {
        burger.setPatty(new BeefPatty());
    }

    @Override
    public void buildSallad() {
        burger.setSallad(new Lettuce());
    }

    @Override
    public void buildPickles() {
        burger.setPickles(new Pickles());
    }

    @Override
    public HesburgerBurger getBurger() {
        return this.burger;
    }
}
