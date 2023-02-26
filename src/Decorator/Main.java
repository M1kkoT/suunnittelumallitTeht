package Decorator;

public class Main {
    public static void main(String[] args) {


        ConcreteDataHandler handler = new ConcreteDataHandler();
        handler.writeToFile("test", "hello world.");

        String data = handler.readFromFile("test");
        System.out.println(data);



        DataHandler handler1 = new EncryptionDecorator(new ConcreteDataHandler());
        handler1.writeToFile("crypted", "this is decorator test no.1 " +
                "we will see if the encryptin will work or not! Here's some numbers: 123,456.6778");
        String message = handler1.readFromFile("crypted");
        System.out.println(message);
    }
}
