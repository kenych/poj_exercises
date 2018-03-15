package exercises.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put(new Key(1, 2, 1), "1");
        map.put(new Key(1, 2, 2), "2");
        System.out.println(map.get(new Key(10, 20, 1)));
    }
}

class Key implements Comparable<Key> {
    int x;
    int y;
    private int id;

    Key(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    @Override
    public int compareTo(Key o) {
        return Integer.valueOf(id).compareTo(o.id);
    }
}
