package info;

import java.util.HashMap;

public class InfoSet {

    private HashMap<String, Object> obj = new HashMap<>();

    public void add(String key, Object add) {
        obj.put(key, add);
    }

    public Object get(String key) {
        return obj.get(key);
    }
}
