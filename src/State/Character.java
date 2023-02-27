package State;

public class Character {
    private evolutionState state;


    public Character(){
        state = firstEvolution.getInstance();
    }

    public void attack(){
        state.performAttack(this);

    }

    public void tellStage(){
        state.tellStage(this);
    }

    public void move(){
        state.move(this);
    }

    public void capture(){
        state.capture(this);
    }

    protected void changeState(evolutionState s){
        state = s;
    }


}
