package exercises.countingchange;

public class N {

    static void printSeq(int num, int a[], int len, int digits) {
        if (num <= 0) {
            for (int j = 0; j < len; j++)     {
                System.out.print(a[j] + ", ");
            }
            System.out.println("");
            return;
        }

        for (int i = digits; i <= num; i++) {
            a[len] = i;
            printSeq(num - i, a, len + 1, i);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        printSeq(5, a, 0, 1);
    }
}
