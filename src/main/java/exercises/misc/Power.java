package exercises.misc;

public class Power {
    public long power(int number, int power) {
        long sum = 1;

        for (int i = 0; i < power; i++) {
            sum *= number;
        }

        return sum;
    }

    public long powerR(int number, int power) {
        return power == 0 ? 1 : number * powerR(number, --power);
    }

    public static void main(String[] args) {
        System.out.println(new Power().power(2, 4));
        System.out.println(new Power().powerR(2, 4));
    }
}
