package datastructures.advanced;

import datastructures.advanced.AdvancedDataException;
import math.CMath;

public class Array3D {

    private int size, sideLength;

    public Array3D(int size) throws AdvancedDataException {
        if (!CMath.isInt(CMath.cubeRoot(size / 1.0))) {
            throw new AdvancedDataException("Array3D must be a cube (size = side ^ 3)!");
        }
        this.size = size;
        sideLength = (int) CMath.cubeRoot(size / 1.0);
    }

    public void addAt(int x, int y, int z) {
    }

    public class DataPoint {

        public final Integer x, y, z;

        public DataPoint(Object data, int x) {
            this.x = x;
            y = null;
            z = null;
        }

        public DataPoint(Object data, int x, int y) {
            this.x = x;
            this.y = y;
            z = null;
        }

        public DataPoint(Object data, int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
