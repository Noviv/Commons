package data.datastructures.exceptions;

/**
 * Exception dealing with bounds.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class ConstraintException extends Exception {

    /**
     * Create a new Constraint exception for borders or bounds.
     *
     * @param msg Constraint error message.
     */
    public ConstraintException(String msg) {
        super(msg);
    }
}
