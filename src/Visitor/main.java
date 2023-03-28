package Visitor;

public class main {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon();

        PokemonVisitor visitor = new BonusVisitor();

        for(int i = 0; i < 10; i++){
            pokemon.tellStage();
            pokemon.capture();
            pokemon.move();
            pokemon.attack();
            //visitor
            pokemon.accept(visitor);

        }


    }
}
