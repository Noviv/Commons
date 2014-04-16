package info;

import java.util.HashMap;
import java.util.Set;

public class InfoSet {

    private HashMap<String, Object> obj = new HashMap<>();

    /**
     * Add a value to the <code>InfoSet</code>.
     *
     * @param key The key.
     * @param add The object to add.
     */
    public void add(String key, Object add) {
        obj.put(key, add);
    }

    /**
     * Get the specific object stored.
     *
     * @param key The key.
     * @return The value of the key.
     */
    public Object get(String key) {
        return obj.get(key);
    }

    public Set<String> getKeys() {
        return obj.keySet();
    }
}
