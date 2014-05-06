package datastructures;

/**
 * Create a new <code>GenericKeyVal</code>, which is basically a one-term
 * {@link java.util.HashMap}.
 *
 * @param <A> Object A.
 * @param <B> Object B.
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

    public void setA(A obj) {
        this.a = obj;
    }

    public void setB(B obj) {
        this.b = obj;
    }

    public boolean same() {
        return a != null && b != null && a.equals(b);
    }
}
