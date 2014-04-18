package math.calculus;

import math.Function;

public class Integration {
    private Integration() {
    }
    
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
