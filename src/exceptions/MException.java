package exceptions;

/**
 * @version 0.3
 * @author Matthew Webb
 */
public class MException extends Exception {

    public static final MException STD_DEV_0_EXCEP = new MException("Standard deviation cannot be 0.");
    public static final MException PROPORTION_OUT_BOUNDS = new MException("A proportion cannot be between 0 and 1, inlusive.");
    public static final MException PROBABILITY_OUT_BOUNDS = new MException("A probability cannot be outisde of 0 and 1.");
    
    private Object errorObj;
    private final String msg;

    /**
     * Creates a new MException exception.
     *
     * @param msg The message to be returned.
     */
    public MException(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * Creates a new MException exception.
     *
     * @param msg The message to be returned.
     * @param errorObj The object where the error occurred.
     */
    public MException(String msg, Object errorObj) {
        super(msg + ": " + errorObj);
        this.errorObj = errorObj;
        this.msg = msg;
    }

    /**
     * Returns the object that caused the error.
     *
     * @return The object that has an error.
     */
    public Object getErrorObject() {
        return errorObj;
    }

    /**
     * Prints the message as an error, as well the error object, if defined.
     */
    public void print() {
        System.err.println(msg + (errorObj != null ? " @" + errorObj : ""));
    }
}
