package math.stats;

public class ListStats {

    private ListStats() {
    }

    public static double mean(int[] ary) {
        double mean = 0;
        for (int i : ary) {
            mean += i;
        }
        mean /= ary.length;
        return mean;
    }

    public static double mean(double[] ary) {
        double mean = 0;
        for (double i : ary) {
            mean += i;
        }
        mean /= ary.length;
        return mean;
    }

    public static double popVariance(double[] ary) {
        double inSum = 0;
        double out = 1.0 / ary.length;
        double mean = mean(ary);
        for (double i : ary) {
            inSum += Math.pow((i - mean), 2);
        }
        return inSum * out;
    }

    public static double sampVariance(double[] ary) {
        double inSum = 0;
        double out = 1.0 / (ary.length - 1);
        double mean = mean(ary);
        for (double i : ary) {
            inSum += Math.pow((i - mean), 2);
        }
        return inSum * out;
    }

    public static double popStdDev(double[] ary) {
        return Math.sqrt(popVariance(ary));
    }

    public static double sampStdDev(double[] ary) {
        return Math.sqrt(sampVariance(ary));
    }
}
