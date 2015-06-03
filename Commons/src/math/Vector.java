package math;

public class Vector {

    private int dimensions;
    private double[] dimensionValues;

    public Vector(int dim) {
        dimensions = dim;
        dimensionValues = new double[dim];
    }

    public void setDimensions(double[] values) {
        setDimensions(dimensions, values);
    }

    public void setDimensions(int dims, double[] values) {
        for (int i = 0; i < values.length; i++) {
            dimensionValues[i] = values[i];
        }
    }

    public int getDimensions() {
        return dimensions;
    }

    public double getMagnitude() {
        double mag = 0.0;
        for (double d : dimensionValues) {
            mag += d * d;
        }
        mag = Math.sqrt(mag);
        return mag;
    }
}
