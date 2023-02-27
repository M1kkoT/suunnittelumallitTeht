package State;

public interface evolutionState {

    public void performAttack(Character c);

    public void tellStage(Character c);

    public void move(Character c);

    public void capture(Character c);

    void changeState(Character c, evolutionState s);
}
