package data.datastructures;

/**
 * A one-term {@link java.util.HashMap}.
 *
 * @param <A> Object A.
 * @param <B> Object B.
 * @author Matthew Webb
 * @version 1.0
 */
public class GenericKeyVal<A, B> {

    /**
     * The first object.
     */
    public A a;

    /**
     * The second object.
     */
    public B b;

    /**
     * Set the A object.
     *
     * @param obj The object to be set.
     */
    public void setA(A obj) {
        this.a = obj;
    }

    /**
     * Set the B object.
     *
     * @param obj The object to be set.
     */
    public void setB(B obj) {
        this.b = obj;
    }

    /**
     * Get whether or not these objects are the same.
     *
     * @return Iff the objects are the same.
     */
    public boolean same() {
        return a != null && b != null && a.equals(b);
    }
}
