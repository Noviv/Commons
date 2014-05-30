package datastructures.specific;

import math.encryption.M1;
import math.encryption.SHA256;

/**
 * Creates a <code>UID</code>, universal indicator director, for all Commons objects.
 */
public class UIDGenerator {

    private UIDGenerator() {
    }

    public static String generate(Object obj) {
        String uid = "";
        uid += obj.hashCode();
        uid += M1.iterativeHash(obj.toString(), uid.length());
        return uid;
    }
    
    public static String generateASCIIBoundary(Object obj) {
        String uid = "";
        uid += obj.hashCode();
        uid += SHA256.iterativeHash(uid, uid.length());
        return uid;
    }
}
