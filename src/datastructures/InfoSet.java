package datastructures;

import java.util.HashMap;
import java.util.Set;

public class InfoSet {

    private final HashMap<String, Object> obj;

    public InfoSet() {
        obj = new HashMap<>();
    }
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

    /**
     * Get the keyset for the <code>InfoSet</code>
     *
     * @return <code>Set</code> of strings.
     */
    public Set<String> getKeys() {
        return obj.keySet();
    }
}
