package math.calculus;

import math.Function;

public class Limit {
    private Limit() {
    }
    
    public static double limit(Function f, int xApr) {
        try {
            return f.func(xApr);
        } catch (Exception e) {
        }
        return 0.0;
    }
}
