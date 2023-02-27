package State;

public class secondEvolution implements evolutionState{
    private int experience = 0;
    private String name = "Ivysaur";
    private static secondEvolution instance = null;
    public static secondEvolution getInstance(){
        if(instance == null){
            instance = new secondEvolution();
        }
        return instance;
    }
    private secondEvolution (){
    }


    @Override
    public void performAttack(Character c) {
        System.out.println("Ivysaur used 'Razor leaf', it dealt 55 dmg");
        experience += 20;
        if(experience >= 100){
            changeState(c, thirdEvolution.getInstance());
        }
    }

    @Override
    public void tellStage(Character c) {
        System.out.println("current stage: " + name);
    }

    @Override
    public void move(Character c) {
        System.out.println(name + " walked 5 meters");
        experience += 10;
        if(experience >= 100){
            changeState(c, thirdEvolution.getInstance());
        }
    }

    @Override
    public void capture(Character c) {
        double num = Math.random();
        if(num < 0.3){
            System.out.println("you succesfully caught Ivysaur");
        }else {
            System.out.println("you didn't manage to catch Ivysaur");
        }
    }

    @Override
    public void changeState(Character c, evolutionState s) {
        c.changeState(s);
        System.out.println("Ivysaur evolved into Venysaur");
    }
}
