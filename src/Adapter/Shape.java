package Adapter;

import java.util.ArrayList;
import java.util.List;


//target
public interface Shape {
    public double area();

    public double perimeter();

    public void scale(double factor);

    Resizer createResizer();


}
