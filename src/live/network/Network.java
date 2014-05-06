package live.network;

import live.exceptions.CreationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import live.network.config.IP;

public final class Network {

    private final String name;
    private final NetworkBuilder nb;

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
        private ServerSocket ss;

        public NetworkHead(IP ip) {
            this.ip = ip;
            try {
                socket = new Socket(ip.host.getAsString(), ip.port.getAsInt());
                ss = new ServerSocket();
            } catch (IOException ex) {
            }
        }
        
        public InputStream getIS() throws IOException {
            return socket.getInputStream();
        }
        
        public OutputStream getOS() throws IOException {
            return socket.getOutputStream();
        }
        
        public void start() {
            try {
                ss.accept();
            } catch (IOException e) {}
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
            for (int i = 0; i < comps.length; i++) {
                if (i == 0) {
                    ((NetworkHead) comps[i]).start();
                } else {
                    
                }
            }
        }
    }
}
