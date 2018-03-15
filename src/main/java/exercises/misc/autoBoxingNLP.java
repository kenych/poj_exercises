package exercises.misc;

import java.util.HashMap;
import java.util.Map;

public class autoBoxingNLP {

    static Map<String, Integer> map = new HashMap();

    static {
        map.put("1", 1);
    }

    public static void main(String[] args) {
        Integer value = getValue("2");
        if(value==null){
            System.out.println("bla bla");
        }


    }

    public static int getValue(String s) {
        return map.get(s);
    }
}
