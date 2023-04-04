package Builder;

public interface BurgerBuilder {

    public abstract void createNewBurgerProduct();

    public abstract void buildBun();

    public abstract void buildMayonnaise();

    public abstract void buildPatty();

    public abstract void buildSallad();

    public abstract void buildPickles();

    public abstract Object getBurger();
}
