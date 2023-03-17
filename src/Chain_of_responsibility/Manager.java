package Chain_of_responsibility;

public class Manager extends Approver {
    private final double approveRate = 0.02;

    public void approveRaise(RaiseRequest request){
        if(request.getAskedRate() <= approveRate){
            System.out.println("Manager will approve a " + request.getAskedRate() + " % raise");
        }else {
            super.approveRaise(request);
        }
    }

}
