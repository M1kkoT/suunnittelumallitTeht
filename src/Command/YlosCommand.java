package Command;

//concrete command
public class YlosCommand implements Command{

    private Valkokangas kangas;

    public YlosCommand(Valkokangas kangas){
        this.kangas = kangas;
    }

    @Override
    public void execute(){
        kangas.ylos();
    }
}
