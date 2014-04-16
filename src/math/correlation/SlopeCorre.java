package math.correlation;

import utils.Coordinate;

public class SlopeCorre {

    private SlopeCorre() {
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
     * @param a The set of data in <code>Coordiante</code>s.
     * @param slope The slope of the expected curve.
     * @return The correlation.
     */
    public static double correlateOne(Coordinate[] a, double slope) {
        Coordinate[] exp = new Coordinate[a.length];
        for (int i = 0; i < exp.length; i++) {
            exp[i].setX(a[i].getX());
            exp[i].setY((int) (slope * a[i].getX()));
        }

        double toReturn = 0.0;
        for (int i = 0; i < a.length; i++) {
            toReturn += Math.abs(a[i].getY() - exp[i].getY());
        }
        assert (a.length == exp.length);
        toReturn /= a.length;
        return toReturn;
    }
}
