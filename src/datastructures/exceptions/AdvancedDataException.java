package datastructures.exceptions;

import utils.Erronous;

/**
 * Exception dealing with advanced data structures or algorithms.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class AdvancedDataException extends Exception {

    private Erronous errObj;

    /**
     * Create a new <code>AdvancedDataException</code>.
     *
     * @param msg The error message.
     */
    public AdvancedDataException(String msg) {
        super(msg);
    }

    /**
     * Create a new <code>AdvancedDataException</code>.
     *
     * @param msg The error message.
     * @param err The object (usually data structure) causing the error.
     */
    public AdvancedDataException(String msg, Erronous err) {
        super(msg);
        errObj = err;
    }
}
