package exercises.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class InsertSort {

    public int[] sort(int[] a) {


        for (int i = 1; i < a.length ; i++) {
            insert(a, i);
        }

        return a;
    }

    private void insert(int[] array, int valuePos) {

        int valueToBeSettled = array[valuePos];

        int prevPos = valuePos - 1;
        while (prevPos >= 0 && array[prevPos] > valueToBeSettled) {
            array[prevPos + 1] = array[prevPos];
            prevPos--;
        }
        array[prevPos + 1] = valueToBeSettled;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Random random2 = new Random();

        System.out.println(random.nextInt(25));
        System.out.println(random2.nextInt(25));


        InsertSort insertSort =new InsertSort();
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(insertSort.sort(arr)));



    }

}
