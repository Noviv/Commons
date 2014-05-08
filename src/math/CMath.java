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
}
