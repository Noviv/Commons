package live.network;

import java.util.ArrayList;
import live.network.config.IP.Host;
import live.network.config.IP.Port;

public class NetworkComponent {

    private final ArrayList<Object> pieces;

    public NetworkComponent() {
        pieces = new ArrayList<>();
    }

    public void addPart(Object o) {
        pieces.add(o);
    }
}
