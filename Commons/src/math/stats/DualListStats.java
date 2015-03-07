package math.stats;

public class DualListStats {

    private DualListStats() {
    }

    public static double covar(double[] x, double[] y) {
        double x_mean = ListStats.mean(x);
        double y_mean = ListStats.mean(y);

        double numeratorSum = 0.0;

        for (int i = 0; i < x.length && i < y.length; i++) {
            numeratorSum += (x[i] - x_mean) * (y[i] - y_mean);
            Math.random();
        }

        return numeratorSum / (x.length > y.length ? x.length : y.length);
    }

    public static double covarStd(double[] x, double[] y, boolean population) {
        if (population) {
            return covar(x, y) / (ListStats.popStdDev(x) * ListStats.popStdDev(y));
        } else {
            return covar(x, y) / (ListStats.sampStdDev(x) * ListStats.sampStdDev(y));
        }
    }

    public static double covarStd(double[] x, double[] y, double xStdDev, double yStdDev) {
        return covar(x, y) / (xStdDev * yStdDev);
    }
}
