package Visitor;

public interface PokemonVisitor {

    void setCurrentPokemon(Pokemon p);
    void visit (Bulbasaur bulbasaur);
    void visit (Ivysaur Ivysaur);
    void visit (Venusaur Venusaur);
}
