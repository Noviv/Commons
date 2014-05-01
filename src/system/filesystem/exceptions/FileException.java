package system.filesystem.exceptions;

import system.filesystem.File;
import system.filesystem.FileGroup;

public class FileException extends Exception {

    /**
     * Exception for when the node and file array of a linked file are of
     * different lengths.
     */
    public static final FileException NODE_AND_NODEARY_MISMATCH = new FileException("Node and file array length mismatch in creating linked file.");

    private File[] error1;
    private FileGroup error2;

    public FileException(String msg) {
        super(msg);
    }

    public FileException(String msg, File... err) {
        super(msg);
        error1 = err;
        error2 = null;
    }

    public FileException(String msg, FileGroup err) {
        super(msg);
        error1 = null;
        error2 = err;
    }
}
