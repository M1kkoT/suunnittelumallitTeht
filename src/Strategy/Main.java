package Strategy;


public class Main {
    public static void main(String[] args) {

        ListConverterStrategy firstStrategy = new firstNewLineStrategy();

        Context c = new Context(firstStrategy);

        ListConverterStrategy secondStrategy = new secondNewLineStrategy();
        ListConverterStrategy thirdStrategy = new thirdNewLineStrategy();

        String list = c.convertList();
        System.out.println(list);

        c.setStrategy(secondStrategy);

        String list2 = c.convertList();
        System.out.println(list2);

        c.setStrategy(thirdStrategy);

        String list3 = c.convertList();
        System.out.println(list3);



        //change list type to char
        c.setList(c.getCharList());


        c.setStrategy(firstStrategy);

        String list4 = c.convertList();
        System.out.println(list4);

        c.setStrategy(secondStrategy);

        String list5 = c.convertList();
        System.out.println(list5);

        c.setStrategy(thirdStrategy);

        String list6 = c.convertList();
        System.out.println(list6);
    }
}
