package live.network;

import exceptions.CreationException;
import java.io.IOException;
import java.net.Socket;
import live.network.config.IP;

public class Network {

    private String name;
    private NetworkBuilder nb;

    public Network(String name, NetworkBuilder nb) {
        this.name = name;
        this.nb = nb;
        assert (this.nb == nb);
        this.nb.build(this);
    }

    public String getName() {
        return name;
    }

    public class NetworkHead extends NetworkComponent {

        public IP ip;

        private Socket socket;

        public NetworkHead(IP ip) {
            this.ip = ip;
            try {
                socket = new Socket(ip.host.getAsString(), ip.port.getAsInt());
            } catch (IOException ex) {
            }
        }
    }

    public class NetworkBuilder {

        private final NetworkComponent[] comps;

        public NetworkBuilder(NetworkComponent... nbcs) throws CreationException {
            if (nbcs[0] instanceof NetworkHead) {
                comps = nbcs;
            } else {
                throw new CreationException("A NetworkHead is required first to create a new Network.");
            }
        }

        public void build(Network n) {
            for (NetworkComponent comp : comps) {
                
            }
        }
    }
}
