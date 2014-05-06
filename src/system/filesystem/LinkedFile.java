package system.filesystem;

import system.filesystem.exceptions.FileException;

public class LinkedFile extends File {

    private final File[] pNodes;
    private final File pNode;
    private int currentIndex;
    private int thisIndex;
    private final boolean singleNode;

    /**
     * Create a new file chain from {@link system.filesystem.File}.
     *
     * @param path Path of the base file.
     * @param singleNode Whether or not it is a single file or not.
     * @param node Array of files to be added to chain.
     * @throws FileException If <code>singleNode</code> and <code>node</code> do
     * not match.
     */
    public LinkedFile(String path, boolean singleNode, File... node) throws FileException {
        super(path);
        this.singleNode = singleNode;
        if (singleNode) {
            if (node.length != 1) {
                throw FileException.NODE_AND_NODEARY_MISMATCH;
            }
            pNodes = null;
            pNode = node[0];
        } else {
            pNode = null;
            pNodes = node;
        }

        if (pNodes != null) {
            for (int i = 0; i < pNodes.length; i++) {
                if (this == pNodes[i]) {
                    thisIndex = i;
                    currentIndex = i;
                }
            }
        } else {
            currentIndex = -1;
            thisIndex = -1;
        }
    }

    public void moveUp() {
        if (pNodes != null) {
            currentIndex++;
        }

    }

    public void moveDown() {
        if (pNodes != null) {
            currentIndex--;
        }
    }

    public File get() {
        return pNodes[currentIndex];
    }

    public String getCD() {
        return pNodes[currentIndex].getAbsolutePath();
    }

    /**
     * Gets whether or not this chain is a single file.
     *
     * @return True if it is a single file.
     */
    public boolean getSingle() {
        return singleNode;
    }

    /**
     * Get the <code>File[]</code> of all files in the chain.
     *
     * @return <code>File[]</code> from chain.
     */
    public File[] toArray() {
        if (singleNode) {
            return new File[]{pNode};
        } else {
            return pNodes;
        }
    }

    /**
     * Write data to all of the files in the chain.
     *
     * @param msg The message to be appended.
     */
    public void appendAll(String msg) {
        if (singleNode) {
            pNode.write(msg, true);
        } else {
            for (File f : pNodes) {
                f.write(msg, true);
            }
        }
    }
}
