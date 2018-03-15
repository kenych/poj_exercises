package exercises;

public class Billing {
    public static void main(String[] args) {
        String s = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
        String[] lines = s.split("\n");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
