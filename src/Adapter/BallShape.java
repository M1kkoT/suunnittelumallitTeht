package Adapter;

//adapter class
public class BallShape extends Ball implements Shape {


    public BallShape(double radius){
        super.setRadius(radius);
    }
    @Override
    public double area() {
        return ((4/3) * Math.PI * (Math.pow(getRadius(), 3)));
    }

    @Override
    public double perimeter() {
        return 4 * Math.PI * (Math.pow(getRadius(), 2));
    }

    @Override
    public void scale(double factor) {
        setRadius(getRadius() * factor);
    }

    @Override
    public Resizer createResizer() {
        return new Resizer(this);
    }
}
