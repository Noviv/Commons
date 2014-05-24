package datastructures;

import math.Vector;
import math.exceptions.MException;
import utils.Mode;

public class DataVector extends Vector {
    private Ternary direction;
    private final Mode mode;
    
    public DataVector(double[][][] data, Mode m) throws MException {
        super("");
        mode = m;
    }
    
    public void put() {
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
                break;
            default:
        }
    }
    
    public void iterateAcross() {
        
    }
}
