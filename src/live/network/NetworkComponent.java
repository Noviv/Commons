package live.network;

import java.util.ArrayList;
import live.network.config.IP.Host;
import live.network.config.IP.Port;

public class NetworkComponent {

    private ArrayList<Object> pieces;

    public NetworkComponent(Host h) {
        pieces = new ArrayList<>();
    }

    public NetworkComponent(Port p) {
        pieces = new ArrayList<>();
    }

    public NetworkComponent() {
        pieces = new ArrayList<>();
    }

    public void addPart(Object o) {
        pieces.add(o);
    }
    
}
