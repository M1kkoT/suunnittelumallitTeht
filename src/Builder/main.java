package Builder;

public class main {
    public static void main(String[] args) {
        purilaisChef chef = new purilaisChef();
        McDonaldsBuilder mcBuilder = new McDonaldsBuilder();
        HesburgerBuilder hsBuilder = new HesburgerBuilder();

        chef.setBurgerBuilder(mcBuilder);
        chef.constructBurger();
        McDonaldsBurger mcBurger = mcBuilder.getBurger();
        System.out.println(mcBurger.toString());


        chef.setBurgerBuilder(hsBuilder);
        chef.constructBurger();
        HesburgerBurger hsBurger = hsBuilder.getBurger();
        System.out.println(hsBurger);


    }
}
