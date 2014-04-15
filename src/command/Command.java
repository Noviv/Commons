package command;

import java.util.ArrayList;
import command.printerrors.Error;

public class Command {

    public static ArrayList<Command> commands = new ArrayList<>();
    public static ArrayList<String> commandCalls = new ArrayList<>();

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
    
    public static final Command STORE = new Command("", "store", new Action() {
        @Override
        public void execute(Object... params) {
            if (params.length > 1) {
                Error.err(Error.TOO_MANY_EXTENSIONS);
            } else {
                
            }
        }
    });

    public String call;
    public String[] extensions;
    private final Action action;

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

    public void execute(Object... params) {
        action.execute(params);
    }

    public static abstract class Action {

        public abstract void execute(Object... params);
    }
}
