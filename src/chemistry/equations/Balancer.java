package chemistry.equations;

import chemistry.exception.ChemException;

public class Balancer {

    private Balancer() {
    }

    public static void balance(String eq) throws ChemException {
        String reactants, products;
        if (eq.contains("=") || eq.contains("==") || eq.contains("=>")) {
            
        } else {
            throw ChemException.EQ_NOT_COMPLETE;
        }
    }
}
