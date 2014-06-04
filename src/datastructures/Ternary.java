package datastructures;

import cInterfaces.Equatable;

public class Ternary extends Number implements Equatable {

    private TernaryCase val;

    public Ternary(TernaryCase value) {
        val = value;
    }

    public Ternary(int value) {
        if (value > 0) {
            val = TernaryCase.HIGH;
        } else if (value == 0) {
            val = TernaryCase.MID;
        } else {
            val = TernaryCase.LOW;
        }
    }

    public TernaryCase get() {
        return val;
    }

    public void set(TernaryCase value) {
        val = value;
    }

    @Override
    public boolean isEqualTo(Object other) {
        if (other instanceof Ternary) {
            return ((Ternary) other).get() == val;
        } else {
            return false;
        }
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0L;
    }

    @Override
    public float floatValue() {
        return 0f;
    }

    @Override
    public double doubleValue() {
        return 0.0;
    }

    public enum TernaryCase {

        HIGH,
        MID,
        LOW;
    }

    public static Ternary convertToTernary(int value) {
        return new Ternary(value);
    }
}
