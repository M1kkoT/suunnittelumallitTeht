package Strategy;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private ListConverterStrategy strategy;
    private List<?> list;
    private String converted;

    public Context(ListConverterStrategy strategy){
        this.strategy = strategy;
        List<Integer> mockList = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            mockList.add(i);
        }
        setList(mockList);

    }

    public void setList(List<?> list){
        this.list = list;
    }

    public String convertList(){
        converted = strategy.listToString(list);
        System.out.println("Converted list using strategy " + strategy.toString());
        return converted;
    }

    public void setStrategy(ListConverterStrategy strategy){
        this.strategy = strategy;

    }

    public List<Character> getCharList(){
        String string = "This is a list of characters";
        ArrayList<Character> charArray = new ArrayList<>();

        for(int i = 0; i < string.length(); i++){
            charArray.add(string.charAt(i));
        }

        return charArray;
    }

}
