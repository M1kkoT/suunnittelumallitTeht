package Command;

//concrete command
public class AlasCommand implements Command{
    private Valkokangas kangas;

    public AlasCommand(Valkokangas kangas){
        this.kangas = kangas;
    }

    @Override
    public void execute(){
        kangas.alas();
    }
}
