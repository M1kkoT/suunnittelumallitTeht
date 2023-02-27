package State;

public class thirdEvolution implements evolutionState{
    private int experience = 0;
    private String name = "Venysaur";

    private boolean cooldown = false;
    private static thirdEvolution instance = null;
    public static thirdEvolution getInstance(){
        if(instance == null){
            instance = new thirdEvolution();
        }
        return instance;
    }
    private thirdEvolution (){
    }


    @Override
    public void performAttack(Character c) {
        if(cooldown){
            System.out.println("Venysaur needs to recover.");
            cooldown = false;
        }else {
            System.out.println("Venysaur used 'Solar beam', it dealt 120 dmg.\nVenysaur needs to recover for a while.");
            experience += 50;
            cooldown = true;
        }

    }

    @Override
    public void tellStage(Character c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Character c) {
        System.out.println(name + " paced 10 meters");
        experience += 20;

    }

    @Override
    public void capture(Character c) {
        double num = Math.random();
        if(num < 0.1){
            System.out.println("you succesfully caught Venysaur");
        }else {
            System.out.println("you didn't manage to catch Venysaur");
        }
    }

    @Override
    public void changeState(Character c, evolutionState s) {
    }
}
