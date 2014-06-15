package command.printerrors;

/**
 * Errors in the Commons command prompt.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class Error {

    /**
     * Thrown if the command does not exist.
     */
    public static final Error COMMAND_NO_INSTANCE = new Error("Command not found.");

    /**
     * Thrown if the command entered has options, but shouldn't.
     */
    public static final Error COMMAND_NO_EXTENSIONS = new Error("Command does not have options.");

    /**
     * Thrown if the command entered has no options, but it should.
     */
    public static final Error COMMAND_NEEDS_EXTENSIONS = new Error("Command needs options.");

    /**
     * Thrown if the option does not exist.
     */
    public static final Error EXTENTION_NO_INSTANCE = new Error("Option does not exist.");

    /**
     * Thrown if the option needs a parameter.
     */
    public static final Error EXTENSION_NEEDS_PARAMETERS = new Error("Option needs a parameter.");

    /**
     * Thrown if the command has too many options.
     */
    public static final Error TOO_MANY_EXTENSIONS = new Error("Too many options.");

    private final String msg;

    /**
     * Create a new error.
     *
     * @param msg The error message.
     */
    public Error(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    /**
     * Print the error.
     *
     * @param err The error to be printed.
     */
    public static void err(Object err) {
        System.err.println(err);
    }
}
