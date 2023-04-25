package Command;

public class Main {
    public static void main(String[] args) {
        Valkokangas kangas = new Valkokangas();

        Command ylos = new YlosCommand(kangas);
        Command alas = new AlasCommand(kangas);

        WallButton button1 = new WallButton(ylos);
        WallButton button2 = new WallButton(alas);

        button1.push();
        button2.push();
    }
}
