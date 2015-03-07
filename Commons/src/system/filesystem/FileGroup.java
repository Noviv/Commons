package system.filesystem;

import java.io.IOException;

public final class FileGroup {

    private final File[] files;
    private boolean createIfNotExist = false;
    private final int head;

    public boolean allReadable = false;
    public boolean allWritable = false;
    public boolean allExecutable = false;

    /**
     * Create a new grouping of file.
     *
     * @param f The array of {@link system.filesystem.File}s.
     * @param create Whether or not to create the files if they don't exist.
     */
    public FileGroup(File[] f, boolean create) {
        files = f;
        createIfNotExist = create;
        head = -1;
    }

    /**
     *
     * @param f The array of {@link system.filesystem.File}s.
     * @param create Whether or not to create the files if they don't exist.
     * @param header The index of the header file (first file = 0).
     */
    public FileGroup(File[] f, boolean create, int header) {
        files = f;
        createIfNotExist = create;
        head = header;
    }

    /**
     * Validate the grouping.
     *
     * @throws IOException If the file cannot be accessed
     */
    public void validate() throws IOException {
        update0();
        for (int i = 0; i < files.length; i++) {
            if (createIfNotExist && files[i].exists()) {
                files[i].createNewFile();
            }

            if (head != -1 && i == head) {
                //verify header
            }
        }
    }

    private void update0() {
        allReadable = true;
        allWritable = true;
        allExecutable = true;
        for (File f : files) {
            if (!f.canRead()) {
                allReadable = false;
            }

            if (!f.canWrite()) {
                allWritable = false;
            }

            if (!f.canExecute()) {
                allExecutable = false;
            }
        }
    }
}
