package exercises.search;

public class BinarySearch {

    public int searchArray(int[] arr, int value) {
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public int searchArrayIter(int[] arr, int value) {
        return searchArrayIter(arr, value, arr.length - 1, 0);
    }

    public int searchArrayIter(int[] arr, int value, int high, int low) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] > value) {
                searchArrayIter(arr, value, mid - 1, low) ;
            } else if (arr[mid] < value) {
                searchArrayIter(arr, value,high, mid + 1) ;
            } else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        System.out.println(bs.searchArray(new int[]{1, 3, 4, 77, 88, 99}, 50));
        System.out.println(bs.searchArray(new int[]{1, 3, 4, 77, 88, 99}, 77));
        System.out.println(bs.searchArray(new int[]{1, 3, 4, 77, 88, 99}, 3));

        System.out.println(bs.searchArrayIter(new int[]{1, 3, 4, 77, 88, 99}, 50));
        System.out.println(bs.searchArrayIter(new int[]{1, 3, 4, 77, 88, 99}, 77));
        System.out.println(bs.searchArrayIter(new int[]{1, 3, 4, 77, 88, 99}, 3));

    }

}
