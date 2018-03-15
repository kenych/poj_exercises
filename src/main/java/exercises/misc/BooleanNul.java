package exercises.misc;

public class BooleanNul {
    public static void main(String[] args) {
        Boolean loginFails = getaNull();
        if (loginFails != null && loginFails) {
            System.out.println("yee");
        }
    }

    private static Boolean getaNull() {
        return null;
    }
}
