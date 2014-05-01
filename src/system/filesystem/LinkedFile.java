package system.filesystem;

public class LinkedFile extends File {
    
    private final File[] pNodes;
    private final File pNode;
    
    public LinkedFile(String path, boolean singleNode, File... node) {
        super(path);
        if (singleNode) {
            pNodes = null;
            pNode = node[0];
        } else {
            pNode = null;
            pNodes = node;
        }
    }
}
