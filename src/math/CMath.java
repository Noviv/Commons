package math;

/**
 * A static class containing things that are not in Java's Math class.
 *
 * @author Matthew Webb
 */
public final class CMath {

    private CMath() {
    }

    /**
     * Calculate the result of a logarithmic function.
     *
     * @param base Base of log function.
     * @param num The x.
     * @return Y value.
     */
    public static double logBase(double base, double num) {
        return Math.log(num) / Math.log(base);
    }

    /**
     * Calculate the result of a logarithmic function with an exponent.
     *
     * @param base Base of log function.
     * @param num The x.
     * @param exponent The power that x will be set to.
     * @return Y value.
     */
    public static double logBase(double base, double num, double exponent) {
        return logBase(base, Math.pow(num, exponent));
    }

    /**
     * Take the square root of a number.
     *
     * @param val The number.
     * @return The square root.
     */
    public static double squareRoot(double val) {
        return baseRoot(val, 2);
    }

    /**
     * Take the cube root of a number.
     *
     * @param val The number.
     * @return The cube root.
     */
    public static double cubeRoot(double val) {
        return baseRoot(val, 3);
    }

    /**
     * Take the root base of a number.
     *
     * @param toRoot The number to be rooted.
     * @param base The base.
     * @return Result.
     */
    public static double baseRoot(double toRoot, int base) {
        return Math.pow(toRoot, 1.0 / base);
    }

    /**
     * Raises e to the power of the argument.
     *
     * @param val Exponent.
     * @return e^val
     */
    public static double exp(double val) {
        return Math.pow(Constants.E, val);
    }

    /**
     * Raises the value to the second power.
     *
     * @param val The value.
     * @return value^2
     */
    public static double square(double val) {
        return raise(val, 2.0);
    }

    /**
     * Raises the value to the third power.
     *
     * @param val The value.
     * @return value^3
     */
    public static double cube(double val) {
        return Math.pow(val, 3.0);
    }

    /**
     * Raises the value to the nth power.
     *
     * @param val The value.
     * @param n The exponent
     * @return value^n
     */
    public static double raise(double val, double n) {
        return Math.pow(val, n);
    }

    /**
     * Invert a value.
     *
     * @param val The value.
     * @return Reciprocal of value.
     */
    public static double inverse(double val) {
        return 1.0 / val;
    }

    /**
     * Checks to see if an object is an int.
     *
     * @param obj Given object to check.
     * @return True means it is an int.
     */
    public static boolean isInt(Object obj) {
        if (obj instanceof Integer) {
            return true;
        }

        try {
            Integer.parseInt(("" + obj).replace(" ", "").toLowerCase().substring(0, ("" + obj).indexOf(".")));
            return true;
        } catch (NumberFormatException e) {
        }

        return false;
    }
}
