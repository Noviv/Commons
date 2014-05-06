package datastructures;

public final class Ternary {

    private int val;

    public Ternary() {

    }

    public int get() {
        return val;
    }

    public enum TernaryCase {

        TRUE,
        HALF,
        FALSE;
    }
}
