package State;

public class main {
    public static void main(String[] args) {
        Character pokemon = new Character();
        for(int i = 0; i < 10; i++){
            pokemon.tellStage();
            pokemon.capture();
            pokemon.move();
            pokemon.attack();
        }
    }
}
