package Adapter;

import java.util.ArrayList;
import java.util.List;

//Local implementation
public class Square implements Shape {

    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }

    @Override
    public void scale(double factor) {
        this.side = this.side * factor;
    }

    @Override
    public Resizer createResizer() {
        return new Resizer(this);
    }
}
