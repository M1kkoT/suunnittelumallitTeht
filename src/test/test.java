package test;

public class test {
    static int multiply(int x, int y) {
        if (x < 1) {
            return x;
        } else {
            return multiply(x - 1, y) + y;
        }
    }

    public static void main(String[] args) {
        int num = multiply(6, 10);
        System.out.println(num);
    }
}
