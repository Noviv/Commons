package command;

import java.util.ArrayList;
import command.printerrors.Error;

/**
 * A new command, used in <code>Prompt</code>.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class Command {

    /**
     * All commands used.
     */
    public static ArrayList<Command> commands = new ArrayList<>();

    /**
     * All the relative command calls
     */
    public static ArrayList<String> commandCalls = new ArrayList<>();

    /**
     * Test command.
     */
    public static final Command TEST = new Command("(blank), -l", "test", new Action() {
        @Override
        public void execute(Object... options) {
            if (options.length == 1) {
                System.out.println("HI THERE");
            } else {
                if (options[1].equals("-l")) {
                    System.out.println("HI THERE YOU TYPED -l");
                } else {
                    Error.err(Error.EXTENTION_NO_INSTANCE);
                }
            }
        }
    });

    /**
     * Connect to a network.
     */
    public static final Command NETWORK = new Command("-n", "network", new Action() {
        @Override
        public void execute(Object... options) {
            if (options.length == 1) {
                Error.err(Error.COMMAND_NEEDS_EXTENSIONS);
            } else {
                if (options[1].equals("-n")) {
                    if (options.length == 3) {
                        System.out.println("Started network on " + options[2]);
                    } else {
                        Error.err(Error.EXTENSION_NEEDS_PARAMETERS);
                    }
                } else {
                    Error.err(Error.EXTENTION_NO_INSTANCE);
                }
            }
        }
    });

    /**
     * Logout of the current system.
     */
    public static final Command LOGOUT = new Command("(blank) -s", "logout", new Action() {
        @Override
        public void execute(Object... params) {
            if (params.length == 1) {
                System.exit(0);
            } else if (params.length == 2 && params[1].equals("-s")) {
                System.out.println("Saving workspace...");
                //save workspace
                System.exit(0);
            } else {
                Error.err(Error.TOO_MANY_EXTENSIONS);
            }
        }
    });

    /**
     * List all the commands and their calls.
     */
    public static final Command HELP = new Command("", "help", new Action() {
        @Override
        public void execute(Object... params) {
            System.out.println("\n\n~~~~HELP~~~~");
            for (Command c : Command.commands) {
                System.out.println(c.call);
                if (c.extensions.length != 0) {
                    for (String s : c.extensions) {
                        System.out.println("-> " + s);
                    }
                }
            }
        }
    });

    /**
     * Save a String to an incrementing variable.
     */
    public static final Command STORE = new Command("", "store", new Action() {
        @Override
        public void execute(Object... params) {
            if (params.length > 1) {
                Error.err(Error.TOO_MANY_EXTENSIONS);
            } else {

            }
        }
    });

    /**
     * The command call.
     */
    public String call;

    /**
     * All extensions that the command can have.
     */
    public String[] extensions;
    private final Action action;

    /**
     * Create a new command.
     *
     * @param exts All extensions.
     * @param call How the command is called.
     * @param a What the action will do when called.
     */
    public Command(String exts, String call, Action a) {
        extensions = exts.split(" ");
        if (extensions[0].equals("")) {
            extensions = new String[0];
        }
        this.call = call;
        action = a;
        Command.commands.add(this);
        Command.commandCalls.add(call);
    }

    /**
     * Execute the command.
     *
     * @param params The parameters for the <code>Action</code>.
     */
    public void execute(Object... params) {
        action.execute(params);
    }

    /**
     * The execution of a command.
     *
     * @author Matthew Webb
     * @version 1.0
     */
    public static abstract class Action {

        /**
         * What a command will do when executed.
         *
         * @param params The user-defined parameters.
         */
        public abstract void execute(Object... params);
    }
}
