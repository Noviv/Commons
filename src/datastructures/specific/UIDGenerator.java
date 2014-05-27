package datastructures.specific;

import math.encryption.M1;

/**
 * Creates a <code>UID</code>, universal indicator director, for all Commons objects.
 */
public class UIDGenerator {

    private UIDGenerator() {
    }

    public static String generate(Object obj) {
        String uid = "";
        uid += obj.hashCode();
        uid += M1.iterativeHash(obj.toString(), 3);
        return uid;
    }
}
