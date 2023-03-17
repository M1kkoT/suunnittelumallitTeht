package Chain_of_responsibility;

public class RaiseRequest {

    private double currentSalary;
    private double askedSalary;



    public RaiseRequest(double currentSalary, double askedSalary){
        this.currentSalary = currentSalary;
        this.askedSalary = askedSalary;

    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public double getAskedSalary() {
        return askedSalary;
    }

    public void setAskedSalary(double askedSalary) {
        this.askedSalary = askedSalary;
    }

    public double getAskedRate(){
        return (double) ((askedSalary - currentSalary) / currentSalary);
    }
}
