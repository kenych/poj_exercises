package exercises.concurrency;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcMapSortedByValue {
    public static void main(String[] args) {


        Comparator<Value> asc = new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                if (!o1.price.equals(o2.price)) {
                    //lower ask price has higher priority
                    return o1.price.compareTo(o2.price);
                } else {
                    return defaultCompare(o1, o2);
                }
            }
        };
        Comparator<Value> des = new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                if (!o1.price.equals(o2.price)) {
                    //higher bid price has higher priority
                    return o2.price.compareTo(o1.price);
                } else {
                    return defaultCompare(o1, o2);
                }

            }
        };

        ConcurrentMap<Key, Value> map = new ConcurrentHashMap<>();

//        Key keyKayan = new Key("kayan", "fb");
//        Key keyDarya = new Key("darya", "fb");
//        Key keyMat = new Key("mat", "fb");
//        Key keyMat2 = new Key("mat2", "fb");

        Value valueKayan = new Value("kayan", "fb", 4, 22, 1);
        Value valueKayan1 = new Value("kayan1", "fb", 4, 22, 2);
        Value valueDarya = new Value("darya", "fb", 4, 33, 3);
        Value valueMat = new Value("mat", "fb", 3, 2, 4);

//        map.put(keyKayan, valueKayan);
//        map.put(keyDarya, valueDarya);
//        map.put(keyMat, valueMat);

        SortedSet<Value> ask = new ConcurrentSkipListSet<>(asc);
        ask.add(valueKayan);
        ask.add(valueKayan1);
        ask.add(valueDarya);
        ask.add(valueMat);

        NavigableSet<Value> bid = new ConcurrentSkipListSet<>(des);
        bid.add(valueKayan);
        bid.add(valueKayan1);
        bid.add(valueDarya);
        bid.add(valueMat);

        show(ask, bid);
//
//        //if price change
//
//        ask.remove(valueMat);
//        bid.remove(valueMat);
//
//        valueMat.price = 12;
//        ask.add(valueMat);
//        bid.add(valueMat);
//
//
//        System.out.println("after amend\n");
//
//        show(ask, bid);
//
        System.out.println("\nshow quote for symbols\n");
//
        System.out.println(ask.first());
        System.out.println(bid.first());
//
//        System.out.println("change add data\n");
//
//        valueMat.shares = 100;
//
//        show(ask, bid);

    }

    //if prices are same, higher shares has higher priority, if they are same then use order
    private static int defaultCompare(Value o1, Value o2) {
        if (!o1.shares.equals(o2.shares)) {
            return o2.shares.compareTo(o1.shares);
        } else {
            return o1.orderId.compareTo(o2.orderId);
        }
    }

    private static void show(SortedSet<Value> ask, SortedSet<Value> bid) {
        System.out.println("asks:");
        for (Value value : ask) {
            System.out.println(value);

        }

        System.out.println("\nbids:");
        for (Value value : bid) {
            System.out.println(value);
        }
    }
}

class Value {
    String name;
    Integer orderId;
    String symbol;
    Integer price;
    Integer shares;


    Value(String name, String symbol, Integer price, Integer shares, Integer orderId) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.shares = shares;
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "Value{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", shares=" + shares +
                '}';
    }

}

class Key {

    String name;
    String symbol;

    @Override
    public String toString() {
        return "Key{" +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    Key(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (!name.equals(key.name)) return false;
        if (!symbol.equals(key.symbol)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }
}
