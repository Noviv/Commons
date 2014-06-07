package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import datastructures.exceptions.ConstraintException;

public class Array3D<E> {

    private int size, sideLength;
    private Object[][][] array;
    private final int maxSeconds;

    public Array3D(int sideLength, int maxSecProcessing) throws AdvancedDataException {
        size = sideLength * sideLength * sideLength;
        this.sideLength = sideLength;
        array = (E[][][]) new Object[sideLength][sideLength][sideLength];
        maxSeconds = maxSecProcessing;
    }

    public E put(E obj, int x, int y, int z) throws ConstraintException {
        if (obj == null) {
            return null;
        }

        if (x > sideLength || y > sideLength || z > sideLength || x < 0 || y < 0 || z < 0) {
            throw new ConstraintException("Cannot place a data value at that point!");
        }
        if (array[x][y][z] == null) {
            array[x][y][z] = obj;
            return null;
        } else {
            E temp = (E) array[x][y][z];
            array[x][y][z] = obj;
            return (E) temp;
        }
    }

    public E pop(int x, int y, int z) {
        return (E) array[x][y][z];
    }

    public E nullPop(int x, int y, int z) {
        E temp = (E) array[x][y][z];
        array[x][y][z] = null;
        return temp;
    }

    public boolean needsAlgorithmicProcessing() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length / 10; i++) {
        }
        return (start - System.currentTimeMillis() > maxSeconds * 1000);
    }
    
    public E[][][] iterator() {
        return (E[][][]) array;
    }
    
    public class DataPoint {

        public final Integer x, y, z;

        /**
         * Dimension of the data point. Ternary LOW means 1D, MID means 2D, and
         * HIGH means 3D.
         */
        public final Ternary dimension;

        public DataPoint(Object data, int x) {
            this.x = x;
            y = null;
            z = null;
            dimension = new Ternary(Ternary.TernaryCase.LOW);
        }

        public DataPoint(Object data, int x, int y) {
            this.x = x;
            this.y = y;
            z = null;
            dimension = new Ternary(Ternary.TernaryCase.MID);
        }

        public DataPoint(Object data, int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            dimension = new Ternary(Ternary.TernaryCase.HIGH);
        }
    }
}
