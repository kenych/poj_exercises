package exercises.weakref;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static java.lang.Integer.parseInt;

public class WeakHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        MyKey myKey = new MyKey(1);
        WeakHashMap<MyKey, String> weakHashMap = new WeakHashMap();
        weakHashMap.put(myKey, "ken");
        System.out.println(weakHashMap.get(myKey));
        myKey = null;
        System.gc();
        Thread.sleep(2000);
        System.out.println(weakHashMap.size());


    }
}


class WeakHashMapExample2 {
    public static void main(String[] args) throws InterruptedException {
        MyKey myKey = new MyKey(1);
        WeakReference<MyKey> weakReference = new WeakReference<MyKey>(myKey);
        Map<WeakReference<MyKey>, String> map = new HashMap();
        map.put(weakReference, "ken");

        myKey = null;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                {while(true);}
            }
        });
        thread.setDaemon(true);
        thread.start();
        thread.join();

    }
}