package exercises.misc;

import java.util.HashMap;
import java.util.Map;

class Mutable implements Cloneable {
    String string;

    Mutable(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mutable mutable = (Mutable) o;

        if (string != null ? !string.equals(mutable.string) : mutable.string != null) return false;

        return true;
    }


    public Mutable clone() {
        try {
            return (Mutable) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Mutable{" +
                "string='" + string + '\'' +
                '}';
    }
}

public class HashCodeAndEq implements Cloneable {
    int x;
    int y;
    Mutable mutable;
    long longVar;

    public HashCodeAndEq(int x, int y, Mutable mutable) {
        this.x = x;
        this.y = y;
        this.mutable = mutable;
    }

    public HashCodeAndEq clone() {
        try {
            HashCodeAndEq cloned = (HashCodeAndEq) super.clone();
            cloned.mutable = mutable.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (mutable != null ? mutable.hashCode() : 0);
        result = 31 * result + (int) (longVar ^ (longVar >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeAndEq that = (HashCodeAndEq) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (mutable != null ? !mutable.equals(that.mutable) : that.mutable != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "HashCodeAndEq{" +
                "x=" + x +
                ", y=" + y +
                ", mutable=" + mutable +
                '}';
    }

    public static void main(String[] args) {
        HashCodeAndEq hashCodeAndEq1 = new HashCodeAndEq(1, 2, new Mutable("ken"));
        HashCodeAndEq hashCodeAndEq2 = hashCodeAndEq1.clone();

        System.out.println("AFTER JUST CLONED");
        System.out.println(hashCodeAndEq1.toString());
        System.out.println(hashCodeAndEq2.toString());
        System.out.println(hashCodeAndEq1.equals(hashCodeAndEq2));


        System.out.println("AFTER FIELDS CHANGE CLONED");
        hashCodeAndEq2.mutable.string = "dash";
        hashCodeAndEq2.x = 10;
        System.out.println(hashCodeAndEq1.equals(hashCodeAndEq2));


        System.out.println(hashCodeAndEq1.toString());
        System.out.println(hashCodeAndEq2.toString());

        Map<HashCodeAndEq, String> map = new HashMap<>();
//        map.put(hashCodeAndEq1, "adfsd");

    }


}
