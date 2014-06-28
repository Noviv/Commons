package utils;

public final class ClassConverter {

    private ClassConverter() {
    }

    public static byte[] convertToByteAry(Byte[] data) {
        byte[] toReturn = new byte[data.length];
        for (int i = 0; i < toReturn.length && i < data.length; i++) {
            toReturn[i] = data[i];
        }
        return toReturn;
    }
}
