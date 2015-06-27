package live.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import live.network.config.IP;

public final class Network {

    private final String name;
    private final NetworkBuilder nb;

    @SuppressWarnings("LeakingThisInConstructor")
    public Network(String name, NetworkBuilder nb) {
        this.name = name;
        this.nb = nb;
        assert (this.nb == nb);
        this.nb.build(this);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return nb.getHead().ip + "";
    }

    public void writeData(Byte[] data, boolean onHead) {
        if (onHead) {
            nb.getHead().writeData(data);
        } else {
        }
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

        public boolean isWriteable() {
            return socket != null && socket.isConnected();
        }

        public void writeData(Byte[] data) {
            try {
                if (getOS() != null && getIS() != null) {
                    byte[] oByte = new byte[data.length];
                    for (int i = 0; i < oByte.length && i < data.length; i++) {
                        oByte[i] = data[i];
                    }
                    getOS().write(oByte);
                }
            } catch (IOException e) {
            }
        }

        public void start() {
            try {
                ss.accept();
            } catch (IOException e) {
            }
        }
    }

    public class NetworkBuilder {

        private final NetworkComponent[] comps;

        public NetworkBuilder(NetworkComponent... nbcs) throws Exception {
            if (nbcs[0] instanceof NetworkHead) {
                comps = nbcs;
            } else {
                throw new Exception("A NetworkHead is required first to create a new network.");
            }
        }

        public NetworkHead getHead() {
            if (comps[0] != null && comps[0] instanceof NetworkHead && ((NetworkHead) comps[0]).isWriteable()) {
                return (NetworkHead) comps[0];
            } else {
                return null;
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
