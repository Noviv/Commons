package info;

public class InfoSet {

    private Object[] data;

    public InfoSet(Object... data) {
        this.data = data;
    }

    public Object[] getData() {
        return data;
    }

    @Override
    public String toString() {
        String toReturn = (String) data[0];
        for (int i = 1; i < data.length; i++) {
            toReturn += "\n" + data[i];
        }
        return toReturn;
    }
}
