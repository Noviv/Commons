package chemistry;

import chemistry.exception.ChemException;
import java.util.ArrayList;

public class ElectronConfig {

    private final String toSplit;
    private String[] split;
    private ArrayList<String> bases;

    public ElectronConfig(String config) throws ChemException {
        bases = new ArrayList<>();
        toSplit = config;
        split = config.split(" ");

        for (String base : split) {
            if (base.contains("s")) {
                if (Integer.parseInt(base.substring(2)) > 2) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("p")) {
                if (Integer.parseInt(base.substring(2)) > 6) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("d")) {
                if (Integer.parseInt(base.substring(2)) > 10) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            } else if (base.contains("f")) {
                if (Integer.parseInt(base.substring(2)) > 14) {
                    throw ChemException.E_CONFIG_BASE_OUT_BOUNDS;
                }
            }
        }

        for (String base : split) {
            for (int i = 1; i <= Integer.parseInt(base.substring(2, 3)); i++) {
                bases.add(base.substring(0, 2) + i);
            }
        }

        for (String base : bases) {
            System.out.println(base);
        }
    }

    public String getUnsplitBase(int index) {
        return split[index];
    }

    public String getSplitBase(int index) {
        return bases.get(index);
    }

    @Override
    public String toString() {
        return toSplit;
    }
}
