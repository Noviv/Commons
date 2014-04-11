package command;

import java.util.Scanner;
import command.printerrors.Error;
import javax.swing.filechooser.FileSystemView;

public final class Prompt {

    private final String baseDirec = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
    private final Scanner input;
    private String cmd;
    private boolean extensions = false;
    
    private char currentVariable = 'a';

    private String[] cmdSplit;
    private boolean firstLine = true;

    public Prompt() {
        input = new Scanner(System.in);
        while (true) {
            cmd = getCmd();
            cmdSplit = cmd.split(" ");
            extensions = cmdSplit.length > 1;
            checkOptions(cmdSplit);
        }
    }

    public void checkOptions(String[] options) {
        if (Command.commandCalls.contains(options[0])) {
            Command.commands.get(Command.commandCalls.indexOf(options[0])).execute(options);
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
