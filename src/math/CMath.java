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
            Integer.parseInt(("" + obj).replace(" ", "").toLowerCase());
            return true;
        } catch (NumberFormatException e) {
        }

        return false;
    }
}
