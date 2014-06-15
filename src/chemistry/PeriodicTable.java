package chemistry;

import chemistry.Constant.ElementClass;
import chemistry.exception.ChemException;
import java.util.HashMap;

/**
 * The periodic table, unfinished.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class PeriodicTable {

    private static final PeriodicTable pt = new PeriodicTable();

    private final HashMap<Integer, Element> elements;

    private PeriodicTable() {
        elements = new HashMap<>();
        loadElements();
    }

    /**
     * Gets the <code>PeriodicTable</code> singleton.
     *
     * @return
     */
    public static PeriodicTable getInstance() {
        return pt;
    }

    private void loadElements() {
        try {
            elements.put(1, new Element("H", 1, 1.00794, ElementClass.NON_METAL, new ElectronConfig("1s1"), 1, 1));
            elements.put(2, new Element("He", 2, 2.00260, ElementClass.NOBLE_GAS, new ElectronConfig("1s2"), 1, 18));
        } catch (ChemException ce) {
        }
    }

    /**
     * Gets an element based on atomic number.
     *
     * @param atomicNumber The atomic number of the goal element.
     * @return The element.
     */
    public Element getElement(int atomicNumber) {
        return elements.get(atomicNumber);
    }
}
