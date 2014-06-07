package math.correlation;

import cInterfaces.S_Equatable;

public class VectorCorrelation implements S_Equatable {

    private double vCorrelation = 0.0;

    public VectorCorrelation() {

    }

    public double getVectorCorrelationCoefficient() {
        update0();
        validate0();
        return vCorrelation;
    }

    private void update0() {
    }

    private void validate0() {
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
        return other instanceof VectorCorrelation && ((VectorCorrelation) other).getVectorCorrelationCoefficient() == vCorrelation;
    }
}
