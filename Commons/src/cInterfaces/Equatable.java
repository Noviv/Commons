package cInterfaces;

/**
 * Comparison within Commons.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public interface Equatable {

    /**
     * Compares an object to this within Commons-constraints.
     *
     * @param other The object to compare to.
     * @return True means that they are equal.
     */
    public boolean isEqualTo(Object other);
}
