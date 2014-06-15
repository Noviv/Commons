package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import math.Vector;
import math.exceptions.MException;
import modeling.Model;

/**
 * A vector made for data organization.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class DataVector extends Vector {

    private Ternary direction;
    private final Mode mode;
    private final boolean search;
    private final Array3D data;

    /**
     *
     * @param data
     * @param m
     * @param searchable
     * @throws MException
     */
    public DataVector(Array3D data, Mode m, boolean searchable) throws MException {
        super("0i + 0j + 0k");
        mode = m;
        search = searchable;
        this.data = data;
    }

    /**
     * Search through the vector.
     *
     * @param m The model to be used as a search algorithm.
     * @throws AdvancedDataException Thrown if the data vector is using the
     * wrong algorithmic process.
     */
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

    /**
     * Gets whether or not the vector is searchable.
     *
     * @return True means that it is searchable.
     */
    public boolean isSearchable() {
        return search;
    }
}
