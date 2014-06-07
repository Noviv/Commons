package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import math.Vector;
import math.exceptions.MException;
import modeling.Model;

public class DataVector extends Vector {

    private Ternary direction;
    private final Mode mode;
    private final boolean search;
    private final Array3D data;

    public DataVector(Array3D data, Mode m, boolean searchable) throws MException {
        super("");
        mode = m;
        search = searchable;
        this.data = data;
    }

    public void search(Model m) throws AdvancedDataException {
        if (data.needsAlgorithmicProcessing()) {
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
                    throw new AdvancedDataException("Invalid DataVector search method!");
            }
        } else {
            for (Object o : data.iterator()) {
                //brute force search
            }
        }
    }

    public boolean isSearchable() {
        return search;
    }
}
