package math.correlation;

import cInterfaces.S_Equatable;

public class VectorCorrelation implements S_Equatable {
    private double vCorrelation = 0.0;
    
    public VectorCorrelation(double[] data) {
        
    }
    
    public double getVectorCorrelationCoefficient() {
        return vCorrelation;
    }
    
    @Override
    public boolean isDataEqualTo(Object o) {
        return false;
    }

    @Override
    public boolean isAllEqualTo(Object... o) {
        return false;
    }

    @Override
    public boolean isEqualTo(Object other) {
        if (other instanceof VectorCorrelation && ((VectorCorrelation) other).getVectorCorrelationCoefficient() == vCorrelation) {
            return true;
        } else {
            return false;
        }
    }
}
