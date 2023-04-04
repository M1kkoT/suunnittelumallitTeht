package Builder;

public class purilaisChef {
    private BurgerBuilder builder;

    public void setBurgerBuilder(BurgerBuilder builder) {
        this.builder = builder;
    }

    public void constructBurger(){
        builder.createNewBurgerProduct();
        builder.buildBun();
        builder.buildMayonnaise();
        builder.buildPatty();
        builder.buildSallad();
        builder.buildPickles();
    }
}
