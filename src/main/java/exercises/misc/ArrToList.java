package exercises.misc;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class ArrToList {
    public ArrToList() {
    }

    public static void main(String[] args) {
        Set<String>  set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        for (String s : set) {
            System.out.println(s);
        }


        asList(new int[]{1, 2, 3}).forEach(System.out::println);
    }
}
