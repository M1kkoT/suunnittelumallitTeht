package Visitor;

public class BonusVisitor implements PokemonVisitor {

    private Pokemon currentPokemon;

    public void setCurrentPokemon(Pokemon p){
        currentPokemon = p;
    }

    @Override
    public void visit(Bulbasaur bulbasaur) {
        //give bonusxp
        currentPokemon.xp += 10;
        System.out.println("gave bulbasaur +10 xp");

    }

    @Override
    public void visit(Ivysaur Ivysaur) {
        //give bonusxp
        currentPokemon.xp += 50;
        System.out.println("gave Ivysaur +50 xp");
    }

    @Override
    public void visit(Venusaur Venusaur) {
        //give bonusxp
        currentPokemon.xp += 100;
        System.out.println("gave Venysaur +100 xp");
    }
}
