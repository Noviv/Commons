package chemistry.equations;

import chemistry.Element;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A chemical equation, complete with products and reactants.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class ChemEquation {

    private final ArrayList<Element> first, second;
    private final boolean full;

    /**
     * Create a new chemical equation.
     *
     * @param equ The equation as a String.
     * @param full True means that the equation is complete.
     */
    public ChemEquation(String equ, boolean full) {
        first = new ArrayList<>();
        second = new ArrayList<>();
        this.full = full;
    }

    /**
     * Create a new chemical equation.
     *
     * @param elems The array of elements to be used. <br> YOU MUST INCLUDE ONE
     * NULL VALUE AFTER THE LIST OF REACTANTS.
     * @param full
     */
    public ChemEquation(Element[] elems, boolean full) {
        first = new ArrayList<>();
        second = new ArrayList<>();
        this.full = full;
        if (full) {
            boolean onReactants = false;
            for (Element elem : elems) {
                if (elem == null) {
                    onReactants = true;
                }
                if (onReactants) {
                    second.add(elem);
                } else {
                    first.add(elem);
                }
            }
        } else {
            first.addAll(Arrays.asList(elems));
        }
    }

    /**
     * Get the list of reactants.
     *
     * @return ArrayList of elements.
     */
    public ArrayList<Element> getReactants() {
        return first;
    }

    /**
     * Get the list of products.
     *
     * @return ArrayList of elements.
     */
    public ArrayList<Element> getProducts() {
        return (second == null ? second : null);
    }
}
