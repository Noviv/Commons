package math.stats;

import exceptions.MException;
import info.InfoSet;

public class Test {

    private Test() {
    }

    public static InfoSet onePropZTest(double p0, int x, int n, PropType type) {
        InfoSet msgs = new InfoSet();
        if (type == PropType.NOT_EQUAL_P0) {
            msgs.add(StatInfoConstant.COMPARE_TYPE, StatInfoConstant.TYPE_NOT_EQUAL_P0);
            msgs.add(StatInfoConstant.SAMPLE_MEAN, (double) (x / n));
            msgs.add(StatInfoConstant.SAMPLE_STD_DEV, Math.sqrt((p0 * (1 - p0)) / n));
            msgs.add(StatInfoConstant.SAMPLE_SIZE, n);
            try {
                msgs.add(StatInfoConstant.Z_SCORE, Test.calcZScore(((double) x / (double) n), p0, Math.sqrt((p0 * (1 - p0)) / n)));//(((x / n) - p0) / Math.sqrt((p0 * (1 - p0)) / n))
            } catch (MException ex) {
            }
            msgs.add(StatInfoConstant.P_VAL, (normalcdf((((x / n) - p0) / Math.sqrt((p0 * (1 - p0)) / n)))));
        } else if (type == PropType.GREATER_THAN_P0) {
            msgs.add(StatInfoConstant.COMPARE_TYPE, StatInfoConstant.TYPE_GREATER_P0);
        } else if (type == PropType.LESS_THAN_P0) {
            msgs.add(StatInfoConstant.COMPARE_TYPE, StatInfoConstant.TYPE_LESS_P0);
        }
        return msgs;
    }

    /**
     * Finds a confidence interval of a proportion.
     *
     * @param proportion The mean proportion.
     * @param critical The critical z or t value.
     * @param n The number of trials.
     * @return An <code>InfoSet</code> with all the data about the confidence
     * interval.
     */
    public static InfoSet confidInt(double proportion, double critical, int n) {
        InfoSet info = new InfoSet();
        info.add(StatInfoConstant.CONFID_INT_TYPE, "Proportion");
        info.add(StatInfoConstant.SAMPLE_SIZE, n);
        info.add(StatInfoConstant.SAMPLE_MEAN, proportion);
        double me = critical * Math.sqrt((proportion * (1 - proportion)) / n);
        info.add(StatInfoConstant.CONFID_INT, "(" + (proportion - me) + ", " + (proportion + me) + ")");
        return info;
    }

    /**
     * Finds a confidence interval or a mean.
     *
     * @param mean The mean of the sample.
     * @param critical The critical z or t value.
     * @param std The standard deviation of the sample.
     * @param n The number of trials in the sample.
     * @return An <code>InfoSet</code> with all the data about the confidence
     * interval.
     */
    public static InfoSet confidInt(double mean, double critical, double std, int n) {
        InfoSet info = new InfoSet();
        info.add(StatInfoConstant.CONFID_INT_TYPE, "Sample");
        info.add(StatInfoConstant.SAMPLE_SIZE, n);
        info.add(StatInfoConstant.SAMPLE_SIZE, mean);
        double me = critical * (std / Math.sqrt((double) n));
        info.add(StatInfoConstant.CONFID_INT, "(" + (mean - me) + ", " + (mean + me) + ")");
        return info;
    }

    /**
     * Converts a probability to a z-score with that alpha value.
     *
     * @param prob The probability.
     * @return The z-score.
     * @throws MException Thrown if the probability given is not inside 0 to 1.
     */
    public static double inverseNorm(double prob) throws MException {
        if (prob > 1 || prob < 0) {
            throw MException.PROBABILITY_OUT_BOUNDS;
        }
        double t = (prob > .5 ? 1.0 - prob : prob);
        double s = Math.sqrt(-2.0 * Math.log(t));
        double a = 2.515517 + (0.802853 * s) + (0.010328 * s * s);
        double b = 1.0 + (1.432788 * s) + (0.189269 * s * s) + (0.001308 * s * s * s);
        double u = s - (a / b);
        return (prob < .5 ? -u : u);
    }

    /**
     * Cumulative probability function. Finds the area under the standard normal
     * curve to the left of the given value.
     *
     * @param valueOnDist The value on the distribution.
     * @return The area under the curve to the left of the value.
     */
    public static double normalcdf(double valueOnDist) {
        double t = (valueOnDist > 0 ? valueOnDist : -valueOnDist);
        double p = 1 - Math.pow((1 + (t * (0.0498673470 + t * (0.0211410061 + t
                * (0.0032776263 + t * (0.0000380036 + t * (0.0000488906 + t
                * 0.0000053830))))))), -16) / 2;
        return (valueOnDist > 0 ? p : 1 - p);
    }

    /**
     * Calculate a z-score with a non-standard distribution.
     *
     * @param x The x value (value on distribution).
     * @param mean The mean of the distribution.
     * @param stdDev The standard deviation of the distribution.
     * @return The z-score.
     * @throws MException Thrown if standard deviation is 0.
     */
    public static double calcZScore(double x, double mean, double stdDev) throws MException {
        if (stdDev == 0) {
            throw MException.STD_DEV_0_EXCEP;
        }

        return (x - mean) / stdDev;
    }
}
