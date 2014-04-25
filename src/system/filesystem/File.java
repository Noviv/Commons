package system.filesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File extends java.io.File {

    private PrintWriter pw;

    public File(String path) {
        super(path);
        try {
            pw = new PrintWriter(this);
        } catch (FileNotFoundException e) {
        }
    }

    public void write(String data, boolean newLine) {
        if (newLine) {
            pw.println(data);
        } else {
            pw.print(data);
        }
    }

    public String read() {
        try {
            Scanner file = new Scanner(this);
            String toReturn = "";
            while (file.hasNext()) {
                toReturn += file.nextLine();
            }
            return toReturn;
        } catch (FileNotFoundException e) {
        }
        return "";
    }

    public String[] readFromRegex(String regex) {
        return null;
    }
}
