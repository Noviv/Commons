package math.calculus;

import math.Function2D;

public class Limit {
    private Limit() {
    }
    
    public static double limit(Function2D f, int xApr) {
        double epsilon = (xApr + 1) * 1e-14;
        try {
            return f.func(xApr);
        } catch (Exception e) {
            return (f.func(xApr + epsilon) + f.func(xApr - epsilon)) / 2;
        }
    }
}
