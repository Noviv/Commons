package chemistry;

import chemistry.ChemConstant.ElementClass;
import java.util.HashMap;

public class PeriodicTable {

    private static PeriodicTable pt = new PeriodicTable();
    
    private HashMap<Integer, Element> elements;
    
    private PeriodicTable() {
        elements = new HashMap<>();
        loadElements();
    }
    
    public static PeriodicTable getInstance() {
        return pt;
    }
    
    private void loadElements() {
        elements.put(1, new Element("H", 1, 1.00794, ElementClass.NON_METAL, new ElectronConfig("1s1"), 1, 1));
    }
    
    public Element getElement(int atomicNumber) {
        return elements.get(atomicNumber);
    }
}
