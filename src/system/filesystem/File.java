package system.filesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File extends java.io.File {

    private PrintWriter pw;

    /**
     * Commons rendition of {@link java.io.File}.
     *
     * @param path File path.
     */
    public File(String path) {
        super(path);
        try {
            pw = new PrintWriter(this);
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * Write data to the file.
     *
     * @param data String of data.
     * @param newLine True means add eoln marker.
     */
    public void write(String data, boolean newLine) {
        if (newLine) {
            pw.println(data);
        } else {
            pw.print(data);
        }
    }

    /**
     * Read the entirety of the file.
     *
     * @return String of the entire file.
     */
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
        try {
            Scanner file = new Scanner(this);
            java.util.ArrayList<String> toReturn = new java.util.ArrayList<>();

        } catch (FileNotFoundException e) {
        }
        return null;
    }

    public PrintWriter getWriter() {
        return pw;
    }
}
