package system.output;

public class Print {

    private Print() {
    }

    /**
     * Print an object on console.
     *
     * @param obj Object to print.
     */
    public static void p(Object obj) {
        if (obj != null) {
            pN(obj + "\n");
        }
    }

    /**
     * Print an object without a new line.
     *
     * @param obj Object to print.
     */
    public static void pN(Object obj) {
        if (obj != null) {
            System.out.print(obj);
        }
    }

    /**
     * Print an object to the error console.
     *
     * @param obj Object to print.
     */
    public static void pE(Object obj) {
        if (obj != null) {
            pEN(obj + "\n");
        }
    }

    /**
     * Print an object to the error console without a new line.
     *
     * @param obj Object to print.
     */
    public static void pEN(Object obj) {
        if (obj != null) {
            System.err.print(obj);
        }
    }
}
