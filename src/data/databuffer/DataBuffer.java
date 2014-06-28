package data.databuffer;

public class DataBuffer<E> {

    private final BufferAlgorithm algorithm;

    public DataBuffer(BufferAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Object[] apply(Object[] data) {
        if (data.length <= 2) {
            return null;
        }
        switch (algorithm) {
            case FRONT_AND_BACK:
                Object[] toReturn = new Object[data.length + 2];
                toReturn[0] = (E) new Object();
                System.arraycopy(data, 0, toReturn, 1, data.length);
                toReturn[toReturn.length - 1] = (E) new Object();
                return toReturn;
            default:
                return null;
        }
    }

    ;

    public final BufferAlgorithm getAlgorithm() {
        return algorithm;
    }
}
