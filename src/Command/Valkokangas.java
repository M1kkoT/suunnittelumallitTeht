package Command;

//receiver
public class Valkokangas {
    private boolean alhaalla = true;

    public void ylos(){
        if(alhaalla){
            System.out.println("Valkokangas nousee ylös");
            alhaalla = false;
        }else {
            System.out.println("Valkokangas on jo ylhäällä");
        }

    }

    public void alas(){
        if(!alhaalla){
            System.out.println("Valkokangas laskee alas");
            alhaalla = true;
        }else {
            System.out.println("Valkokangas on jo alhaalla");
        }

    }
}
