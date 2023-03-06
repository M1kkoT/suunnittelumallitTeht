package Strategy;

import java.util.List;

public class thirdNewLineStrategy implements ListConverterStrategy{
    @Override
    public String listToString(List<?> list) {

        String conversion = "";

        Object[] array = list.toArray();

        for(int i = 0; i < array.length; i++){
            conversion += array[i];
            if(((i + 1) % 3) == 0){
                conversion += "\n";
            }

        }
        return conversion;
    }

    @Override
    public String toString(){
        return "thirdNewLineStrategy";
    }
}
