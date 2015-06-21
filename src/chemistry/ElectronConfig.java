package chemistry;

import chemistry.exception.ChemException;
import java.util.ArrayList;

/**
 * Electron configuration of an element.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class ElectronConfig {

    private final String toSplit;
    private final String[] split;
    private final ArrayList<String> bases;

    /**
     * Create a new electron configuration.
     *
     * @param config The string consisting of the entire configuration.
     * <br><br>Example: "1s2 2s2 2p5".
     * @throws ChemException Thrown if any of the orbitals are overfilled or negative.
     */
    public ElectronConfig(String config) throws ChemException {
        bases = new ArrayList<>();
        toSplit = config;
        split = config.split(" ");

        for (String base : split) {
            if (base.contains("s")) {
                if (Integer.parseInt(base.substring(2)) > 2 || Integer.parseInt(base.substring(2)) < 0) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("p")) {
                if (Integer.parseInt(base.substring(2)) > 6 || Integer.parseInt(base.substring(2)) < 0) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("d")) {
                if (Integer.parseInt(base.substring(2)) > 10 || Integer.parseInt(base.substring(2)) < 0) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("f")) {
                if (Integer.parseInt(base.substring(2)) > 14 || Integer.parseInt(base.substring(2)) < 0) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            }
        }

        for (String base : split) {
            for (int i = 1; i <= Integer.parseInt(base.substring(2, 3)); i++) {
                bases.add(base.substring(0, 2) + i);
            }
        }
    }

    /**
     * Get an actual base of the electron configuration (from the inputted string).
     *
     * @param index The index of the orbital.
     * @return The base as a <code>String</code>.
     */
    public String getUnsplitBase(int index) {
        return split[index];
    }

    /**
     * Gets the split base, as in the partial base of the
     *
     * @param index Index of part of electron configuration.
     * @return String in electron configuration.
     */
    public String getSplitBase(int index) {
        return bases.get(index);
    }

    @Override
    public String toString() {
        return toSplit;
    }
}
