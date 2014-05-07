package datastructures;

public final class Ternary {

    private TernaryCase val;

    public Ternary(TernaryCase value) {
        val = value;
    }

    public TernaryCase get() {
        return val;
    }

    public void set(TernaryCase value) {
        val = value;
    }

    public enum TernaryCase {

        TRUE,
        HALF,
        FALSE;
    }
}
