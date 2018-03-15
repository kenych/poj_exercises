package exercises.misc;

public class MultiplyWithNoOperator {
    public int multiply(int number, int multiplier) {
        int sum = 0;
        for (int i = 0; i < multiplier; i++) {
            sum += number;
        }
        return sum;
    }

    public int multiplyR(int number, int multiplier) {
        return multiplier == 0 ? 0 : multiplyR(number, --multiplier) + number;
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyWithNoOperator().multiply(2, 3));
        System.out.println(new MultiplyWithNoOperator().multiplyR(3, 5));
    }
}
