package live.network;

import data.databuffer.BufferAlgorithm;
import data.databuffer.DataBuffer;
import live.exceptions.CreationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import live.network.config.IP;
import utils.ClassConverter;

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
            nb.getHead().writeData(data, false);
        } else {
        }
    }

    public class NetworkHead extends NetworkComponent {

        public IP ip;

        private Socket socket;
        private ServerSocket ss;
        private DataBuffer buffer;

        public NetworkHead(IP ip) {
            this.ip = ip;
            buffer = new DataBuffer(BufferAlgorithm.FRONT_AND_BACK);
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

        public void writeData(Byte[] data, boolean hasBuffer) {
            if (!hasBuffer) {
                buffer.apply(data);
            }

            try {
                if (getOS() != null && getIS() != null) {
                    getOS().write(ClassConverter.convertToByteAry(data));
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

        public NetworkBuilder(NetworkComponent... nbcs) throws CreationException {
            if (nbcs[0] instanceof NetworkHead) {
                comps = nbcs;
            } else {
                throw new CreationException("A NetworkHead is required first to create a new network.");
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
