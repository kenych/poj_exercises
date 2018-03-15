package exercises;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List list= new ArrayList() ;
        list.add("sdfs");
        list.add(1);
        String s = (String) list.get(0);
        int i = (Integer) list.get(1);

    }

}
