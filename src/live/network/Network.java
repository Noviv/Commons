package live.network;

import exceptions.CreationException;

public class Network {

    private String name;

    public Network(String name, NetworkBuilder nb) {
        this.name = name;
        nb.build(this);
    }

    public String getName() {
        return name;
    }

    public class NetworkHead extends NetworkComponent {

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
//                if () {

//                }
            }
        }
    }
}
