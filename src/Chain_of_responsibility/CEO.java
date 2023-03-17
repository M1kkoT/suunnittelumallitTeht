package Chain_of_responsibility;

public class CEO extends Approver{

    public void approveRaise(RaiseRequest request) {

        System.out.println("CEO will approve a " + request.getAskedRate() + " % raise");
    }

}
