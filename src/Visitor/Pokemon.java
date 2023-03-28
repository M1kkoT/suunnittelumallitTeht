package Visitor;

public class Pokemon {
    private evolutionState state;

    public Pokemon(){
        state = Bulbasaur.getInstance();
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

    public void accept(PokemonVisitor visitor){
        state.accept(visitor);
    }


    protected void changeState(evolutionState s){
        state = s;
    }


}
