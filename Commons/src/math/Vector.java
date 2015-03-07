package math;

import math.exceptions.MException;

/**
 * @version 0.3
 * @author Matthew Webb
 */
public class Vector {

    /**
     * The i axis of the vector.
     */
    public static final String AXIS_I = "i";

    /**
     * The j axis of the vector.
     */
    public static final String AXIS_J = "j";

    /**
     * The k axis of the vector.
     */
    public static final String AXIS_K = "k";

    private final String vectorNotation;
    private int begX, begY, begZ, endX, endY, endZ;
    private String[] terms;

    /**
     * Creates a new GVector3D object.
     *
     * @param begX Beginning x coordinate.
     * @param begY Beginning y coordinate.
     * @param begZ Beginning z coordinate.
     * @param endX Ending x coordinate.
     * @param endY Ending y coordinate.
     * @param endZ Ending z coordinate.
     */
    public Vector(int begX, int begY, int begZ, int endX, int endY, int endZ) {
        terms = new String[2];
        terms[0] = "" + (endX - begX) + "i";
        terms[1] = "" + (endY - begY) + "j";
        terms[2] = "" + (endZ - begZ) + "k";
        vectorNotation = terms[0] + " " + terms[1] + " " + terms[2];

        this.begX = begX;
        this.begY = begY;
        this.begZ = begZ;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
    }

    /**
     * Creates a new Vector object for a unit vector.
     *
     * @param ijkForm The vector in vector notation (ai + bj + ck).
     * @throws MException Thrown if your String does not contain i, j, or k.
     */
    public Vector(String ijkForm) throws MException {
        vectorNotation = ijkForm;

        if (ijkForm.contains("i") && ijkForm.contains("j") && ijkForm.contains("k")) {
            terms = ijkForm.split("\\+");
        } else {
            throw new MException("Not in vector notation (or missing i, j, or k).");
        }

        begX = -1;
        begY = -1;
        begZ = -1;
        endX = -1;
        endY = -1;
        endZ = -1;
    }

    /**
     * Gets a specific term of the vector, from vector notation using a given
     * axis. It is suggested that you use the constants in the Vector class.
     *
     * @param axis Which term (i, j, or k) will be returned.
     * @param include Determines whether or not to include the i, j, or k.
     * @return The term as a String. Includes the i, j, or k if include == true.
     */
    public String getSpecificTerm(String axis, boolean include) {
        for (String term : terms) {
            if (term.contains(axis)) {
                if (!include) {
                    return term.substring(0, term.lastIndexOf(axis));
                } else {
                    return term;
                }
            }
        }

        return "!ERROR!";
    }

    /**
     * Gets a specific term of the vector, from vector notation using an index.
     *
     * @param index The specific index of the String[] of terms.
     * @param include Determines whether or not to include the i, j, or k.
     * @return The term as a String. Includes the i, j, or k if include == true.
     */
    public String getSpecificTerm(int index, boolean include) {
        if (include) {
            return terms[index].substring(0, terms[index].lastIndexOf(terms[index].length() - 1));
        } else {
            return terms[index];
        }
    }

    @Override
    public String toString() {
        return "GVector3D is " + vectorNotation + " @" + Integer.toHexString(hashCode());
    }
}
