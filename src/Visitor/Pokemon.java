package Visitor;

public class Pokemon {
    private evolutionState state;

    protected int xp;

    public Pokemon(evolutionState state){
        this.state = state;
        xp = 0;
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
        visitor.setCurrentPokemon(this);
        state.accept(visitor);
    }


    protected void changeState(evolutionState s){
        state = s;
    }


}
