package datastructures.advanced;

import datastructures.Ternary;
import datastructures.exceptions.AdvancedDataException;
import datastructures.exceptions.ConstraintException;

/**
 * A 3D array.
 *
 * @author Matthew Webb
 * @param <E> The object that it will be made of.
 */
public class Array3D<E> {

    private int size, sideLength;
    private Object[][][] array;
    private final int maxSeconds;

    /**
     * @param sideLength The length of the side of the cube of data.
     * @param maxSecProcessing The maximum time that processing should take.
     */
    public Array3D(int sideLength, int maxSecProcessing) {
        size = sideLength * sideLength * sideLength;
        this.sideLength = sideLength;
        array = (E[][][]) new Object[sideLength][sideLength][sideLength];
        maxSeconds = maxSecProcessing;
    }

    /**
     * Put an object at a location.
     *
     * @param obj The object to be set.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param z Z coordinate.F
     * @return The object set.
     * @throws ConstraintException Thrown if x, y, or z are out of bounds.
     */
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

    /**
     * Get the value at a location.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param z Z coordinate.
     * @return The object at the location.
     */
    public E pop(int x, int y, int z) {
        return (E) array[x][y][z];
    }

    /**
     * Get the value at a location, then set that location to null.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param z Z coordinate.
     * @return The value at the location.
     */
    public E nullPop(int x, int y, int z) {
        E temp = (E) array[x][y][z];
        array[x][y][z] = null;
        return temp;
    }

    /**
     * Gets whether or not this cube is too big to be non-iteratively processed.
     *
     * @return True means that this data set is too big.
     */
    public boolean needsAlgorithmicProcessing() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length / 10; i++) {
        }
        return (start - System.currentTimeMillis() > maxSeconds * 1000);
    }

    /**
     * Get the array of data to be iterated across.
     *
     * @return The array of <code>E</code> objects.
     */
    public E[][][] iterator() {
        return (E[][][]) array;
    }

    /**
     * A location in a array.
     */
    public class DataPoint {

        /**
         * A coordinate.
         */
        public final Integer x, y, z;

        /**
         * Dimension of the data point. Ternary LOW means 1D, MID means 2D, and
         * HIGH means 3D.
         */
        public final Ternary dimension;

        /**
         * Create a new data point.
         *
         * @param data The object data.
         * @param x The 1D location.
         */
        public DataPoint(Object data, int x) {
            this.x = x;
            y = null;
            z = null;
            dimension = new Ternary(Ternary.TernaryCase.LOW);
        }

        /**
         * Create a new data point.
         *
         * @param data The object data.
         * @param x The 2D x coordinate.
         * @param y The 2D y coordinate.
         */
        public DataPoint(Object data, int x, int y) {
            this.x = x;
            this.y = y;
            z = null;
            dimension = new Ternary(Ternary.TernaryCase.MID);
        }

        /**
         * Create a new data point.
         *
         * @param data The object data.
         * @param x The 3D x coordinate.
         * @param y The 3D y coordinate.
         * @param z The 3D z coordinate.
         */
        public DataPoint(Object data, int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            dimension = new Ternary(Ternary.TernaryCase.HIGH);
        }
    }
}
