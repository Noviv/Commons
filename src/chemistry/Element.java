package chemistry;

import chemistry.Constant.ElementClass;

public class Element {

    public final String symbol;
    public final int atomicNum;
    public final double atomicWeight;
    public final ElementClass classification;
    public final ElectronConfig configuration;
    public final int period, group;

    /**
     * Creates a new element.
     *
     * @param symbol The simple symbol for the element.
     * @param atomicNum The atomic number of the element.
     * @param atomicWeight The atomic weight, amu, of the element.
     * @param classification The classification of the element.
     * @param config The electron configuration of the element.
     * @param period The period of the element.
     * @param group The group of the element.
     */
    public Element(String symbol, int atomicNum, double atomicWeight, ElementClass classification, ElectronConfig config, int period, int group) {
        this.symbol = symbol;
        this.atomicNum = atomicNum;
        this.atomicWeight = atomicWeight;
        this.classification = classification;
        configuration = config;
        this.period = period;
        this.group = group;
    }
}
