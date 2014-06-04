package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import math.Vector;
import math.exceptions.MException;
import utils.Mode;

public class DataVector extends Vector {

    private Ternary direction;
    private final Mode mode;
    private final boolean search;

    public DataVector(Mode m, boolean searchable) throws MException {
        super("");
        mode = m;
        search = searchable;
    }

    public DataVector(double[][][] data, Mode m, boolean searchable) throws MException {
        super("");
        mode = m;
        search = searchable;
    }

    public void put() throws AdvancedDataException {
        switch (mode) {
            case GRAB:
                break;
            case LOCALBUNDLE:
                break;
            case BOUNCE:
                break;
            case QUEUE:
                break;
            case PACKET:
                throw new AdvancedDataException("Cannot handle packet DataVector search!");
            default:
        }
    }

    public boolean isSearchable() {
        return search;
    }
}
