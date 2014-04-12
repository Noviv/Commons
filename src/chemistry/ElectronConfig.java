package chemistry;

import chemistry.exception.ChemException;
import java.util.ArrayList;

public class ElectronConfig {

    private final String toSplit;
    private String[] split;
    private ArrayList<String> bases;

    public static void main(String[] args) {
        System.out.println(new ElectronConfig("1s2 2s2 2p6").getBase(2));
    }
    
    public ElectronConfig(String config) {
        toSplit = config;
        split = config.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("s")) {
                for (int t = 1; t <= Integer.parseInt(split[i].substring(2)); i++) {
                    bases.add(split[i].substring(0, 1) + t);
                }
            }
        }
    }

    public String getBase(int index) {
        return split[index];
    }
    
    public void getPartialBase() {
        
    }
    
    public void getPartialElement() {
        
    }

    @Override
    public String toString() {
        return toSplit;
    }
}
