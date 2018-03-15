package exercises.countingchange;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


public class CountingChange {

    static List<Integer> coins = newArrayList(4, 3, 2, 1);

    List<Integer> findMain(int number, List<Integer> coins) {

        System.out.println("coins: " + coins);
        for (Integer coin : coins) {
            find(number, coin, coins);
        }

        return null;
    }

    List<Integer> find(int change, int coin, List<Integer> coins) {
        List<List<Integer>> allList = newArrayList();
        System.out.println("change: " + change + " coin: " + coin);

        int multiplier = change / coin;
        System.out.println("multiplier :" + multiplier);

        int left = change % coin;
        System.out.println("left :" + left);

        if (coins.contains(left) || left == 0) {

            List<Integer> list = newArrayList();
            for (int i = 0; i < multiplier; i++) {
                list.add(coin);
            }

            if (left != 0) {
                list.add(left);
            }

            allList.add(list);


            System.out.println("main: " + allList);


            if (coin > 1) {

                List<Integer> t = newArrayList(coins);
                t.remove(new Integer(coin));

                findMain(coin, t);
            }else{
                return list;
            }


        }

        return newArrayList();

    }

    public static void main(String[] args) {

        new CountingChange().findMain(7, coins);

    }


}
