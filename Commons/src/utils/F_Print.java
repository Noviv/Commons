package utils;

import static utils.Print.p;

public class F_Print {

    private F_Print() {
    }

    /**
     * Prints a string with parameters inside the string (rendition of C's
     * <code>printf()</code>). Replaces %a, then %b, then %c,
     * etc.<br><br>Example:<br>
     * <code>print("Here is a String: %a, and here is another object: %b", "hello", 12345);</code>
     * <br><br>Note: creates an alias for the message string.
     *
     * @param msg The string with % parameters.
     * @param swap The objects to be swapped in.
     */
    public static void print(String msg, Object... swap) {
        String alias = msg;
        char currentChar = 'a';
        for (Object obj : swap) {
            alias = alias.replace("%" + currentChar, "" + obj);
            currentChar++;
        }
        p(alias);
    }
}
