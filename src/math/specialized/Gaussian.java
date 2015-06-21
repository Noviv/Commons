package math.specialized;

import math.CMath;
import math.Constants;

public class Gaussian {

    /**
     * Gaussian bell curve equation.
     *
     * @param a A parameter.
     * @param b B parameter.
     * @param c C parameter.
     * @param x Point on bell curve.
     * @return Heigh of bell curve.
     */
    public static double gaussian(double a, double b, double c, double x) {
        return a * CMath.exp(-CMath.square(x - b) / (2 * CMath.square(c)));
    }

    /**
     * Get the value of the Gaussian probability density function at a certain
     * point.
     *
     * @param mu Random variable mean.
     * @param sigma Random variable standard deviation.
     * @param x Point on x-axis.
     * @return Probability that the random variable will occur.
     */
    public static double gaussianPDF(double mu, double sigma, double x) {
        return CMath.inverse(sigma * CMath.squareRoot(2.0 * Constants.PI)) * CMath.exp(-.5 * CMath.square((x - mu) / sigma));
    }

}
