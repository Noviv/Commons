package math.correlation;

public class SlopeCorrelation {

    private SlopeCorrelation() {
    }

    public static double correlateData(double[] a1, double[] a2) {
        double toReturn = 0.0;
        if (a1.length == a2.length) {
            for (int i = 0; i < a1.length && i < a2.length; i++) {
                toReturn += Math.abs(a1[i] - a2[i]);
            }
            assert (a1.length == a2.length);
            toReturn /= a1.length;
        }
        return toReturn;
    }

    /**
     * Correlate a set of data based on a slope.
     *
     * @param ax X coordinates of data set.
     * @param ay Y coordinates of data set.
     * @param slope The slope of the expected curve.
     * @return The correlation.
     */
    public static double correlateOne(double[] ax, double[] ay, double slope) {
        double[] expx = new double[ax.length];
        double[] expy = new double[ay.length];
        for (int i = 0; i < expx.length; i++) {
            expx[i] = ax[i];
            expy[i] = slope * ax[i];
        }

        double toReturn = 0.0;
        for (int i = 0; i < ax.length; i++) {
            toReturn += Math.abs(ay[i] - expy[i]);
        }
        toReturn /= ax.length;
        return toReturn;
    }
}
