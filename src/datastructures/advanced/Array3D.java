package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import datastructures.exceptions.ConstraintException;
import math.CMath;

public class Array3D<E> {

    private int size, sideLength;
    private Object[][][] array;

    public Array3D(int size) throws AdvancedDataException {
        if (!CMath.isInt(CMath.cubeRoot(size / 1.0))) {
            throw new AdvancedDataException("Array3D must be a cube (size = side ^ 3)!");
        }
        this.size = size;
        sideLength = (int) CMath.cubeRoot(size / 1.0);
        array = new Object[sideLength][sideLength][sideLength];
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
