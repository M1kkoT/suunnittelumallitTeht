package Adapter;


//adaptee
public class Ball implements ThreeDimentionalShape{
    private double radius;


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
