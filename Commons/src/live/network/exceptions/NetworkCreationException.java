package live.network.exceptions;

import live.network.config.IP;
import live.network.config.IP.Host;
import live.network.config.IP.Port;

public class NetworkCreationException extends Exception {

    private final IP error;

    public NetworkCreationException(String msg, IP errIP) {
        super(msg);
        error = errIP;
    }

    public NetworkCreationException(String msg, Host h, Port p) {
        super(msg);
        error = new IP(h, p);
    }

    public IP getErrorIP() {
        return error;
    }
}
