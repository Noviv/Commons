package chemistry;

import chemistry.exception.ChemException;
import java.util.ArrayList;

public class Molecule {

    private ArrayList<MoleculeBase> molecule;

    public Molecule(Element[] elems, int[] freqs) throws ChemException {
        if (elems.length != freqs.length) {
            throw ChemException.MOLECULE_ELEM_AND_FREQ_NO_MATCH;
        }

        molecule = new ArrayList<>();

        for (int i = 0; i < elems.length && i < freqs.length; i++) {
            molecule.add(new MoleculeBase(elems[i], freqs[i]));
        }
    }
    
    @Override
    public String toString() {
        String toReturn = "";
        for (MoleculeBase b : molecule) {
            toReturn += b;
        }
        return toReturn;
    }

    private class MoleculeBase {

        public final Element e;
        public final int freq;

        public MoleculeBase(Element e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return e.symbol + freq;
        }
    }
}
