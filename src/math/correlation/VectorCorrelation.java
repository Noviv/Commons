package math.correlation;

import cInterfaces.S_Equatable;
import datastructures.DataVector;
import math.exceptions.MException;
import utils.Mode;

public class VectorCorrelation implements S_Equatable {

    private double vCorrelation = 0.0;
    private DataVector searchVectorX, searchVectorY, searchVectorZ;

    public VectorCorrelation() {
        try {
            searchVectorX = new DataVector(Mode.BOUNCE, true);
            searchVectorY = new DataVector(Mode.BOUNCE, true);
            searchVectorZ = new DataVector(Mode.BOUNCE, true);
        } catch (MException e) {
        }
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
