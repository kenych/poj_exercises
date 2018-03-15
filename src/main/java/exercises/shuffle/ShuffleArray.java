package exercises.shuffle;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;
import static java.util.Arrays.toString;

public class ShuffleArray {

    void shuffle(int[] array) {

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            swap(i, random.nextInt(array.length -i)+1, array);
        }

    }

    private void swap(int source, int destination, int[] array) {

        int initialSourceValue = array[source];
        array[source] = array[destination];
        array[destination] = initialSourceValue;
        System.out.println("source: "+source+ " dest: "+destination+ " array: "+Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3,4,5,6,7};
        out.println(Arrays.toString(array));
        new ShuffleArray().shuffle(array);
        out.println(Arrays.toString(array));

    }

}
