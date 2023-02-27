package State;

public class firstEvolution implements evolutionState {

    private int experience = 0;
    private String name = "Bulbasaur";
    private static firstEvolution instance = null;
    public static firstEvolution getInstance(){
        if(instance == null){
            instance = new firstEvolution();
        }
        return instance;
    }
    private firstEvolution (){
    }


    @Override
    public void performAttack(Character c) {
        System.out.println("Bulbasaur used 'Vine whip', it dealt 45 dmg");
        experience += 10;
        if(experience >= 30){
            changeState(c, secondEvolution.getInstance());
        }
    }

    @Override
    public void tellStage(Character c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Character c) {
        System.out.println(name + " slowly walked 2 meters");
        experience += 5;
        if(experience >= 30){
            changeState(c, secondEvolution.getInstance());
        }
    }

    @Override
    public void capture(Character c) {
        double num = Math.random();
        if(num < 0.5){
            System.out.println("you succesfully caught Bulbasaur");
        }else {
            System.out.println("you didn't manage to catch Bulbasaur");
        }
    }

    @Override
    public void changeState(Character c, evolutionState s) {
        c.changeState(s);
        System.out.println("Bulbasaur evolved into Ivysaur!");
    }
}
