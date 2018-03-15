package exercises.weakref;

public class MyKey {
    int i;

    public MyKey(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyKey myKey = (MyKey) o;

        if (i != myKey.i) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return i;
    }
}
