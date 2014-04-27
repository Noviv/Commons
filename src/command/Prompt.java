package command;

import java.util.Scanner;
import command.printerrors.Error;
import java.util.HashMap;
import javax.swing.filechooser.FileSystemView;

public final class Prompt {

    private final String baseDirec = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
    private final Scanner input;
    private String cmd;
    private boolean extensions = false;

    private HashMap<Character, String> variables;
    private char currentVariable = 'a';

    private String[] cmdSplit;
    private boolean firstLine = true;

    public Prompt() {
        variables = new HashMap<>();
        input = new Scanner(System.in);
        while (true) {
            cmd = getCmd();
            cmdSplit = cmd.split(" ");
            extensions = cmdSplit.length > 1;
            checkOptions(cmdSplit);
        }
    }

    public void checkOptions(String[] options) {
        if (options[0].equals("store")) {
            if (options.length > 2) {
                Error.err(Error.COMMAND_NO_EXTENSIONS);
            } else if (options.length == 1) {
                Error.err(Error.EXTENSION_NEEDS_PARAMETERS);
            } else {
                variables.put(currentVariable, options[1]);
                System.out.println("Stored under " + currentVariable);
                currentVariable++;
            }

        } else if (options[0].equals("get")) {
            System.out.println(variables.get(options[1].toCharArray()[0]));
        } else if (Command.commandCalls.contains(options[0])) {
            Command.commands.get(Command.commandCalls.indexOf(options[0])).execute((Object[]) options);
        } else {
            Error.err(Error.COMMAND_NO_INSTANCE);
        }
    }

    public String getCmd() {
        if (firstLine) {
            System.out.print(baseDirec + " --> ");
            firstLine = false;
        } else {
            System.out.print("\n" + baseDirec + " --> ");
        }
        return input.nextLine();
    }
}
