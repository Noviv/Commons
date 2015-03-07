package system.filesystem;

public class LinkedFile extends File {

    private LinkedFile prev;

    public LinkedFile(String path, LinkedFile prev) {
        super(path);
        this.prev = prev;
    }

    public LinkedFile getPrev() {
        return prev;
    }
}
