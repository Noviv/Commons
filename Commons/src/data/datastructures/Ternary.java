package data.datastructures;

import cInterfaces.Equatable;

/**
 * Create a ternary. Meant to act as a boolean for 3 values.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class Ternary implements Equatable {

    private TernaryCase val;

    /**
     * Create a new ternary using <code>TernaryCase</code>.
     *
     * @param value The standard value.
     */
    public Ternary(TernaryCase value) {
        val = value;
    }

    /**
     * Create a new ternary using an integer.
     *
     * @param value The integer that this object will be based on.
     */
    public Ternary(int value) {
        if (value > 0) {
            val = TernaryCase.HIGH;
        } else if (value == 0) {
            val = TernaryCase.MID;
        } else {
            val = TernaryCase.LOW;
        }
    }

    /**
     * Get the standard ternary.
     *
     * @return A <code>TernaryCase</code>.
     */
    public TernaryCase get() {
        return val;
    }

    /**
     * Set the ternary.
     *
     * @param value What to set the ternary to.
     */
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

    /**
     * The standard ternary cases.
     */
    public enum TernaryCase {

        HIGH,
        MID,
        LOW;
    }

    /**
     * Get a new ternary from an integer.
     *
     * @param value The integer to be based on.
     * @return The ternary.
     */
    public static Ternary convertToTernary(int value) {
        return new Ternary(value);
    }
}
