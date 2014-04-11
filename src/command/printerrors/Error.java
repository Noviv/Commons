package command.printerrors;

public class Error {

    public static final Error COMMAND_NO_INSTANCE = new Error("Command not found.");
    public static final Error COMMAND_NO_EXTENSIONS = new Error("Command does not have options.");
    public static final Error COMMAND_NEEDS_EXTENSIONS = new Error("Command needs options.");
    public static final Error EXTENTION_NO_INSTANCE = new Error("Option does not exist.");
    public static final Error EXTENSION_NEEDS_PARAMETERS = new Error("Option needs a parameter.");
    public static final Error TOO_MANY_EXTENSIONS = new Error("Too many options.");

    private final String msg;

    public Error(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    public static void err(Object err) {
        System.err.println(err);
    }
}
