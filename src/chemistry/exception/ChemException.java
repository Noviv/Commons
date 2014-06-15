package chemistry.exception;

import utils.Erronous;

/**
 * Exception dealing with Commons chemistry.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class ChemException extends Exception {

    /**
     * Thrown if an electron configuration has no base.
     */
    public static final ChemException E_CONFIG_BASE_NOT_FOUND = new ChemException("Electron configuration base could not be found.");

    /**
     * Thrown if a term of an electron configuration is impossible.
     */
    public static final ChemException E_CONFIG_BASE_OUT_BOUNDS = new ChemException("One of your electron configuration bases was not correct.");

    /**
     * Thrown if the number of elements and number of frequencies are not equal.
     */
    public static final ChemException MOLECULE_ELEM_AND_FREQ_NO_MATCH = new ChemException("Molecule's element and frequency arrays do not match length.");

    /**
     * Thrown if the chemical equation is incomplete.
     */
    public static final ChemException EQ_NOT_COMPLETE = new ChemException("Chemical equation is not complete!");

    private Erronous object;

    /**
     * Create a new chemistry exception.
     *
     * @param msg The error.
     */
    public ChemException(String msg) {
        super(msg);
    }

    /**
     * Create a new chemistry exception with a cause.
     *
     * @param msg The error.
     * @param obj The causing object.
     */
    public ChemException(String msg, Erronous obj) {
        super(msg);
        object = obj;
    }

    /**
     * Get the object that caused the error.
     *
     * @return The Erronous that caused the error, or null if the exception was
     * not initialized with one.
     */
    public Erronous getErrorObj() {
        return object;
    }
}
