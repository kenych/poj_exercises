package exercises.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Misc {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndAdd(2);
        System.out.println(atomicInteger);

        ConcurrentHashMap map = new ConcurrentHashMap();
        System.out.println(map.putIfAbsent("ken", "xxx"));
        System.out.println(map.putIfAbsent("ken", "1"));
        System.out.println(map.putIfAbsent("ken", "2"));




    }
}
