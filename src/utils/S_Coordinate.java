package utils;

/**
 * @version 0.3
 * @author Matthew Webb
 */
public final class S_Coordinate {

    private double x, y;

    /**
     * Creates a new S_Coordinate object (double x and y).
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public S_Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate.
     *
     * @return
     */
    public double getX() {
        return x;
    }
    
    /**
     * Get the y coordinate.
     *
     * @return The y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Set the x coordinate.
     *
     * @param x The x coordinate.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set the y coordinate.
     *
     * @param y The y coordinate.
     */
    public void setY(double y) {
        this.y = y;
    }
}
