package math;

import exceptions.MException;

/**
 * @version 0.3
 * @author Matthew Webb
 */
public class Function {

    private final String toParse;
    private String preE, postE;
    private String[] terms;
    private int numTerms = 1;

    /**
     * Creates a new Function.
     *
     * @param function The function as a string. Must not contain sqrt or ().
     * @throws MException Math exception.
     */
    public Function(String function) throws MException {
        toParse = function.toLowerCase().replace(" ", "").trim();
        parseFunction(toParse);
    }

    /**
     * Reads the function.
     *
     * @param s Function as a string.
     * @throws exceptions.MException Math exception.
     */
    private void parseFunction(String s) throws MException {
        if (s.contains("=")) {
            preE = s.substring(0, s.indexOf("="));
            postE = s.substring(s.indexOf("=") + 1, s.length());
            for (int x = 0; x < s.length(); x++) {
                if (s.charAt(x) == '+') {
                    numTerms++;
                }
            }

            terms = postE.split("\\+");
        } else {
            throw new MException("Not a function!", s);
        }
    }

    /**
     * Returns the number of terms in the function.
     *
     * @return Number of terms in the function.
     */
    public int getNumTerms() {
        return numTerms;
    }

    /**
     * Returns a String[] of all the terms.
     *
     * @return Terms in the function as a String[].
     */
    public String[] getTerms() {
        return terms;
    }

    /**
     * Calculates y for a given x. Fixed multiplication bug in v0.3.
     *
     * @param x The x value of the function.
     * @return The y value of the function for a given x.
     */
    public int func(int x) {
        int temp = 0, y = 0;

        for (String term : terms) {
            if (term.contains("x")) {
                if (!term.startsWith("x") || !term.endsWith("x")) {
                    if (term.contains("^")) {
                        temp = (int) Math.pow((double) x, (double) Integer.parseInt(term.substring(term.lastIndexOf("^") + 1)));
                        if (!term.startsWith("x")) {
                            temp *= Integer.parseInt(term.substring(0, term.lastIndexOf("x")));
                            y += temp;
                            temp = 0;
                        } else {
                            y += temp;
                            temp = 0;
                        }
                    } else {
                        try {
                            temp = Integer.parseInt(term.substring(0, term.lastIndexOf("x")));
                            y += temp * x;
                            temp = 0;
                        } catch (NumberFormatException e) {
                            y += x;
                        }
                    }
                } else {
                    y += x;
                }
            } else {
                y += Integer.parseInt(term);
            }
        }

        return y;
    }

    /**
     * Prints the value of y for a given x.
     *
     * @param x The value of x from which y is to be calculated.
     */
    public void printFunc(int x) {
        System.out.println(func(x));
    }

    /**
     * Prints out function and value as a sentence.
     *
     * @param x The value of x to be calculated.
     */
    public void printFullFunc(int x) {
        System.out.println("For the equation " + toParse + " an x of " + x + " is " + func(x));
    }

    @Override
    public String toString() {
        return "Function is " + toParse + " @" + Integer.toHexString(super.hashCode());
    }
}
