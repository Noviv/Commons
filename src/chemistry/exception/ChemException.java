package chemistry.exception;

import chemistry.Element;

public class ChemException extends Exception {

    public static final ChemException E_CONFIG_BASE_NOT_FOUND = new ChemException("Electron configuration base could not be found.");

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
