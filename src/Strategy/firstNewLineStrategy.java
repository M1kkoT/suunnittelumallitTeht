package Strategy;

import java.util.List;

public class firstNewLineStrategy implements ListConverterStrategy{
    @Override
    public String listToString(List<?> list) {
        String conversion = "";
        for(int i = 0; i < list.size(); i++){
            conversion += list.get(i) + "\n";
        }
        return conversion;
    }

    @Override
    public String toString(){
        return "firstLineStrategy";
    }
}
