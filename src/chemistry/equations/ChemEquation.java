package chemistry.equations;

import chemistry.Element;
import java.util.ArrayList;
import java.util.Arrays;

public class ChemEquation {

    private final ArrayList<Element> first, second;
    private final boolean full;

    public ChemEquation(String equ, boolean full) {
        first = new ArrayList<>();
        second = new ArrayList<>();
        this.full = full;
    }

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
                    first.add(elem);
                } else {
                    second.add(elem);
                }
            }
        } else {
            first.addAll(Arrays.asList(elems));
        }
    }

    public ArrayList<Element> getReactants() {
        return first;
    }

    public ArrayList<Element> getProducts() {
        return (second == null ? second : null);
    }
}
