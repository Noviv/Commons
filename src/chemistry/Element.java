package chemistry;

import chemistry.ChemConstant.ElementClass;

public class Element {

    public final String symbol;
    public final int num;
    public final double weight;
    public final ElementClass classification;
    public final ElectronConfig configuration;
    public final int period, group;

    public Element(String symbol, int atomicNum, double atomicWeight, ElementClass classification, ElectronConfig config, int period, int group) {
        this.symbol = symbol;
        num = atomicNum;
        weight = atomicWeight;
        this.classification = classification;
        configuration = config;
        this.period = period;
        this.group = group;
    }
}
