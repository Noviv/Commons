package system.filesystem;

import java.io.IOException;

public final class FileGroup {

    private final File[] files;
    private boolean createIfNotExist = false;
    private final int head;

    public boolean allReadable = false;
    public boolean allWritable = false;
    public boolean allExecutable = false;

    public FileGroup(File[] f, boolean create) {
        files = f;
        createIfNotExist = create;
        head = -1;
    }

    public FileGroup(File[] f, boolean create, int header) {
        files = f;
        createIfNotExist = create;
        head = header;
    }

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
