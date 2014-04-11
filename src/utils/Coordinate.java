package utils;

/**
 * @version 0.3
 * @author Matthew Webb
 */
public class Coordinate {

    private int x, y;

    /**
     * Creates a new SimpleCoordinateHolder object.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate.
     *
     * @return The y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Set the x coordinate.
     *
     * @param x The x coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y coordinate.
     *
     * @param y The y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
}
