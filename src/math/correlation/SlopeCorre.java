package math.correlation;

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
    
    public static double correlateOne(double[] a, double slope) {
        
        return 0.0;
    }
}
