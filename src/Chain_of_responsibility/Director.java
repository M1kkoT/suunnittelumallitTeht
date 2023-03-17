package Chain_of_responsibility;

public class Director extends Approver {

    private final double approveRate = 0.05;

    public void approveRaise(RaiseRequest request){
        if(request.getAskedRate() <= approveRate){
            System.out.println("Director will approve a " + request.getAskedRate() + " % raise");
        }else {
            super.approveRaise(request);
        }
    }



}
