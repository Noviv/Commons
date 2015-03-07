package live.network.config;

import java.util.ArrayList;

public class IP {
    public Host host;
    public Port port;

    public IP(Host h, Port p) {
        
    }

    public class Host {

        public ArrayList<Integer> host;
        private final String hostStr;

        public Host(String host) {
            this.host = new ArrayList<>();
            hostStr = host;
            for (String s : host.split(".")) {
                this.host.add(Integer.parseInt(s));
            }
        }
        
        public String getAsString() {
            return hostStr;
        }
    }

    public class Port {

        public final int port;

        public Port(int p) {
            port = p;
        }
        
        public int getAsInt() {
            return port;
        }
    }
}
