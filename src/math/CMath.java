package math;

public class CMath {

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
     * Take the cube root of a number
     *
     * @param toCRoot The number to cube root.
     * @return The cube root of toCRoot.
     */
    public static double cubeRoot(double toCRoot) {
        return baseRoot(toCRoot, 3);
    }

    public static double baseRoot(double toRoot, int base) {
        return Math.pow(toRoot, 1.0 / base);
    }
}
