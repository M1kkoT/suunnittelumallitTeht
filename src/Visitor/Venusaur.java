package Visitor;

public class Venusaur extends evolutionState {

    private String name = "Venusaur";

    private boolean cooldown = false;
    private static Venusaur instance = null;
    public static Venusaur getInstance(){
        if(instance == null){
            instance = new Venusaur();
        }
        return instance;
    }
    private Venusaur(){
    }

    @Override
    public void accept(PokemonVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void performAttack(Pokemon c) {
        if(cooldown){
            System.out.println("Venysaur needs to recover.");
            cooldown = false;
        }else {
            System.out.println("Venysaur used 'Solar beam', it dealt 120 dmg.\nVenysaur needs to recover for a while.");
            c.xp += 50;
            cooldown = true;
        }

    }

    @Override
    public void tellStage(Pokemon c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Pokemon c) {
        System.out.println(name + " paced 10 meters");
        c.xp += 20;

    }

    @Override
    public void capture(Pokemon c) {
        double num = Math.random();
        if(num < 0.1){
            System.out.println("you succesfully caught Venysaur");
        }else {
            System.out.println("you didn't manage to catch Venysaur");
        }
    }

    @Override
    public void changeState(Pokemon c, evolutionState s) {
    }
}
