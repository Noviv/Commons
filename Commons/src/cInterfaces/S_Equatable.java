package cInterfaces;

/**
 * More specific comparison within Commons.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public interface S_Equatable extends Equatable {

    /**
     * Compares data within this object and another object.
     *
     * @param o The other object to compare data to.
     * @return True means that the data within both objects are equal.
     */
    public boolean isDataEqualTo(Object o);

    /**
     * Array of objects comparison.
     *
     * @param o Objects to compare to this object.
     * @return True means that all the objects are equal to this object.
     */
    public boolean isAllEqualTo(Object... o);
}
