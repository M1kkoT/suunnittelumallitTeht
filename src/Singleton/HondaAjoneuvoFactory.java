package Singleton;



public class HondaAjoneuvoFactory implements AjoneuvoFactory{


    private HondaAjoneuvoFactory(){}
    private static HondaAjoneuvoFactory instance = null;

    public static HondaAjoneuvoFactory getInstance(){
        if (instance == null) {
            instance = new HondaAjoneuvoFactory();
        }
        return instance;
    }



    @Override
    public Ajoneuvo makeHenkiloAuto() {
        return new HondaHenkiloAuto();
    }

    @Override
    public Ajoneuvo makeRekkaAuto() {
        return new HondaRekkaAuto();
    }
}
