package chemistry.exception;

import chemistry.Element;

public class ChemException extends Exception {

    public static final ChemException E_CONFIG_BASE_NOT_FOUND = new ChemException("Electron configuration base could not be found.");
    public static final ChemException E_CONFIG_BASE_OUT_BOUNDS = new ChemException("One of your electron configuration bases was not correct.");
    public static final ChemException MOLECULE_ELEM_AND_FREQ_NO_MATCH = new ChemException("Molecule's element and frequency arrays do not match length.");

    private Object err;

    public ChemException(String msg) {
        super(msg);
    }

    public ChemException(String msg, Object errObj) {
        super(msg);
        err = errObj;
    }

    public ChemException(String msg, Element relative) {
        super(msg);
        err = relative;
    }
}
