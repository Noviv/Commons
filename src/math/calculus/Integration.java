package math.calculus;

import math.Function;

public class Integration {

    private Integration() {
    }

    /**
     * Brute-force algorithm for calculating an integration.
     *
     * @param f The function to be integrated over.
     * @param low The start point.
     * @param high The end point.
     * @return The integral of the function.
     */
    public static double integrate(Function f, double low, double high) {
        double area = 0.0;
        double dx = Double.MIN_VALUE;
        while (low < high) {
            area += dx * f.func(low);
            low += dx;
        }
        return area;
    }
}
