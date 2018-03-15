package exercises.misc;

import java.lang.reflect.Field;

public class IntegerCache {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 2;

        Field valField = a.getClass().getDeclaredField("value");
        valField.setAccessible(true);
        valField.setInt(a, 3);

        Integer b = 2;
        Integer c = 1;

        System.out.println("b+c : " + (b+c) ); // b+c : 4
    }

}
