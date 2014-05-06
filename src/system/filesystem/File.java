package system.filesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File extends java.io.File {

    private PrintWriter pw;
    private Scanner in;

    /**
     * Commons rendition of {@link java.io.File}.
     *
     * @param path File path.
     */
    public File(String path) {
        super(path);
        try {
            pw = new PrintWriter(this);
            in = new Scanner(this);
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
        String toReturn = "";
        while (in.hasNext()) {
            toReturn += in.nextLine();
        }
        return toReturn;
    }

    /**
     * Get the <code>PrintWriter</code> associated with this file.
     *
     * @return The <code>Writer</code> that can print to this file.
     */
    public PrintWriter getWriter() {
        return pw;
    }
}
