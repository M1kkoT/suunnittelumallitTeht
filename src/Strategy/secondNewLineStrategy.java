package Strategy;

import java.util.Iterator;
import java.util.List;

public class secondNewLineStrategy implements ListConverterStrategy{
    @Override
    public String listToString(List<?> list) {

        String conversion = "";

        Iterator<?> it = list.iterator();

        int counter = 0;

        while (it.hasNext()){
            conversion += it.next();
            counter++;
            if(counter >= 2){
                conversion += "\n";
                counter = 0;
            }
        }
        return conversion;
    }

    @Override
    public String toString(){
        return "secondNewLineStrategy";
    }
}
