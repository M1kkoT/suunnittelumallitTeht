package Builder;

public class McDonaldsBuilder implements BurgerBuilder{

    private McDonaldsBurger burger;

    @Override
    public void createNewBurgerProduct() {
        burger = new McDonaldsBurger();
    }

    @Override
    public void buildBun() {
        burger.setBun("purilaisSämpylä");
    }

    @Override
    public void buildMayonnaise() {
        burger.setMayo("majoneesi");
    }

    @Override
    public void buildPatty() {
        burger.setPatty("100g naudanlihapihvi");
    }

    @Override
    public void buildSallad() {
        burger.setSallad("salaatti");
    }

    @Override
    public void buildPickles() {
        burger.setPickles("suolakurkku");
    }

    @Override
    public McDonaldsBurger getBurger() {
        return this.burger;
    }
}
