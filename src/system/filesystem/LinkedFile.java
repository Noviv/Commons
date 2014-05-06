package system.filesystem;

import system.filesystem.exceptions.FileException;

public class LinkedFile extends File {

    private final File[] pNodes;
    private final File pNode;
    private int currentIndex;
    private int thisIndex;

    public LinkedFile(String path, boolean singleNode, File... node) throws FileException {
        super(path);
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
}
