package exercises.guava;

import com.google.common.base.Optional;

public class Optionals {
    public static void main(String[] args) {
        Optional<String> optional = Optional.absent();

        System.out.println(optional.or(method1()).or(method2()));
    }

    private static Optional<? extends String> method3() {
        System.out.println(3);
        return Optional.absent();

    }

    private static Optional<String> method2() {
        System.out.println(2);
        return Optional.of("2");
//        return Optional.of("2");
    }

    private static Optional<String> method1() {
        System.out.println(1);
        return Optional.absent();
//        return Optional.of("1");

    }
}
