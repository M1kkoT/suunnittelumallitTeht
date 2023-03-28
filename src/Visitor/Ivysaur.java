package Visitor;

public class Ivysaur extends evolutionState {
    private String name = "Ivysaur";
    private static Ivysaur instance = null;
    public static Ivysaur getInstance(){
        if(instance == null){
            instance = new Ivysaur();
        }
        return instance;
    }
    private Ivysaur(){
    }


    @Override
    public void accept(PokemonVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void performAttack(Pokemon c) {
        System.out.println("Ivysaur used 'Razor leaf', it dealt 55 dmg");
        experience += 20;
        if(experience >= 130){
            changeState(c, Venusaur.getInstance());
        }
    }

    @Override
    public void tellStage(Pokemon c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Pokemon c) {
        System.out.println(name + " walked 5 meters");
        experience += 10;
        if(experience >= 130){
            changeState(c, Venusaur.getInstance());
        }
    }

    @Override
    public void capture(Pokemon c) {
        double num = Math.random();
        if(num < 0.3){
            System.out.println("you succesfully caught Ivysaur");
        }else {
            System.out.println("you didn't manage to catch Ivysaur");
        }
    }

    @Override
    public void changeState(Pokemon c, evolutionState s) {
        c.changeState(s);
        System.out.println("Ivysaur evolved into Venysaur");
    }
}
