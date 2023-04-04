package Adapter;

public class Resizer {
    private Shape shape;

    public Resizer(Shape shape){
        this.shape = shape;
    }

    public void scale(double factor){
        shape.scale(factor);
    }
}
