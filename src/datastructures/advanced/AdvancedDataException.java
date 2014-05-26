package datastructures.advanced;

import utils.Erronous;

public class AdvancedDataException extends Exception {

    private Erronous errObj;

    public AdvancedDataException(String msg) {
        super(msg);
    }

    public AdvancedDataException(String msg, Erronous err) {
        super(msg);
        errObj = err;
    }
}
