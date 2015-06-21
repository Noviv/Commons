package chemistry;

/**
 * Elemental constants, used for the periodic table.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public enum Constant {

    /**
     * A null element.
     */
    BLANK;

    public enum ElementClass {

        /**
         * A non-metal element.
         */
        NON_METAL,
        /**
         * A metal element.
         */
        METAL,
        /**
         * A metalloid element.
         */
        METALLOID,
        /**
         * A noble gas element.
         */
        NOBLE_GAS;
    }
}
