package Chain_of_responsibility;

public abstract class Approver {
    private Approver successor;

    public void setSuccessor(Approver successor){
        this.successor = successor;
    }

    public void approveRaise(RaiseRequest request){
        if (successor != null){
            successor.approveRaise(request);
        }
    }
}
