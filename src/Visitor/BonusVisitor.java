package Visitor;

public class BonusVisitor implements PokemonVisitor {
    @Override
    public void visit(Bulbasaur bulbasaur) {
        //give bonusxp
        bulbasaur.experience += 10;
        System.out.println("gave bulbasaur +10 xp");

    }

    @Override
    public void visit(Ivysaur Ivysaur) {
        //give bonusxp
        Ivysaur.experience += 50;
        System.out.println("gave Ivysaur +50 xp");
    }

    @Override
    public void visit(Venusaur Venusaur) {
        //give bonusxp
        Venusaur.experience += 100;
        System.out.println("gave Venysaur +100 xp");
    }
}
