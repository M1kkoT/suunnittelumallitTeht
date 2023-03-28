package Visitor;

public abstract class evolutionState {

    public void performAttack(Pokemon c){};

    public void tellStage(Pokemon c){};

    public void move(Pokemon c){};

    public void capture(Pokemon c){};

    public void accept(PokemonVisitor visitor) {};


    void changeState(Pokemon c, evolutionState s){};
}
