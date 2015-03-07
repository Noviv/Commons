package live.network;

import java.util.ArrayList;

public class NetworkGroup {

    private ArrayList<String> calls;
    private ArrayList<Network> networks;

    public NetworkGroup() {
        networks = new ArrayList<>();
    }

    public void put(String key, Network n) {
        calls.add(key);
        networks.add(n);
    }

    public Network get(String key) {
        return networks.get(calls.indexOf(key));
    }

    public void remove(String key) {
        networks.remove(calls.indexOf(key));
        calls.remove(key);
    }

    public void remove(Network n) {
        calls.remove(networks.indexOf(n));
        networks.remove(n);
    }
}
