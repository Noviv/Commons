package math.entropy;

import java.util.HashMap;
import java.util.Map;
import static math.CMath.logBase;

public class ShannonEntropy {

    private ShannonEntropy() {
    }

    /**
     * Using the Shannon algorithm for data encryption algorithm, get the
     * entropy of a String.
     *
     * @param s The String off which entropy should be calculated.
     * @return The entropy.
     */
    public static double getShannonEntropy(String s) {
        int n = 0;
        Map<Character, Integer> occ = new HashMap<>();

        for (int c_ = 0; c_ < s.length(); ++c_) {
            char cx = s.charAt(c_);
            if (occ.containsKey(cx)) {
                occ.put(cx, occ.get(cx) + 1);
            } else {
                occ.put(cx, 1);
            }
            ++n;
        }

        double e = 0.0;
        for (Map.Entry<Character, Integer> entry : occ.entrySet()) {
            char cx = entry.getKey();
            double p = (double) entry.getValue() / n;
            e += p * logBase(2, p);
        }
        return -e;
    }
}
