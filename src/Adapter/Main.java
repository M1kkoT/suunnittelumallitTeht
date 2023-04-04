package Adapter;

public class Main {
    public static void main(String[] args) {
        Shape shape = new BallShape(12);
        Shape shape1 = new Square(30);

        Resizer sqrResizer = shape1.createResizer();
        Resizer ballResizer = shape.createResizer();

        System.out.println("Volume of the Ball: " + shape.area());
        System.out.println("Area of the square; " + shape1.area());

        ballResizer.scale(2.0);
        sqrResizer.scale(0.5);

        System.out.println("Volume of the ball: " + shape.area());
        System.out.println("Area of the square; " + shape1.area());


    }
}
