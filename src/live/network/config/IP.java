package live.network.config;

import java.util.ArrayList;

public class IP {

    public IP(Host h, Port p) {

    }

    public class Host {

        public ArrayList<Integer> host;

        public Host(String host) {
            this.host = new ArrayList<>();
            for (String s : host.split(":")) {
                this.host.add(Integer.parseInt(s));
            }
        }
    }

    public class Port {

        public final int port;

        public Port(int p) {
            port = p;
        }
    }
}
