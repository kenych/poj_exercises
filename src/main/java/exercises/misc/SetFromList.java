package exercises.misc;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

public class SetFromList {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        System.out.println(new HashSet<>(list));
        System.out.println(new BigDecimal("1000500286982"));
    }
}
