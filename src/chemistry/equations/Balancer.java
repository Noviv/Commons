package chemistry.equations;

import chemistry.exception.ChemException;

public final class Balancer {

    private Balancer() {
    }

    /**
     * Balance a chemical equation from a string.
     *
     * @param eq The string containing whatever you want to balance. Use "=" as
     * the yields sign.
     * @throws ChemException If there is no "=" or no products/reactants.
     */
    public static void balance(String eq) throws ChemException {
        String reactants, products;
        if (eq.contains("=")) {
            reactants = eq.split("=")[0].replace(" ", "");
            products = eq.split("=")[1].replace(" ", "");
            System.out.println(reactants);
            System.out.println(products);
        } else {
            throw ChemException.EQ_NOT_COMPLETE;
        }
    }
}
