package Visitor;

public class Bulbasaur extends evolutionState {

    private String name = "Bulbasaur";
    private static Bulbasaur instance = null;
    public static Bulbasaur getInstance(){

        if(instance == null){
            instance = new Bulbasaur();
        }
        return instance;
    }
    private Bulbasaur(){
    }


    @Override
    public void performAttack(Pokemon c) {
        System.out.println("Bulbasaur used 'Vine whip', it dealt 45 dmg");
        experience += 10;
        if(experience >= 30){
            changeState(c, Ivysaur.getInstance());
        }
    }

    @Override
    public void accept(PokemonVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void tellStage(Pokemon c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Pokemon c) {
        System.out.println(name + " slowly walked 2 meters");
        experience += 5;
        if(experience >= 30){
            changeState(c, Ivysaur.getInstance());
        }
    }

    @Override
    public void capture(Pokemon c) {
        double num = Math.random();
        if(num < 0.5){
            System.out.println("you succesfully caught Bulbasaur");
        }else {
            System.out.println("you didn't manage to catch Bulbasaur");
        }
    }

    @Override
    public void changeState(Pokemon c, evolutionState s) {
        c.changeState(s);
        System.out.println("Bulbasaur evolved into Ivysaur!");
    }
}
