package live.network.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import live.network.Network;
import system.filesystem.File;

public class NetworkProfile {

    private File config;
    private Network network;

    public NetworkProfile(Network n) {
        network = n;
        config = new File("/" + n.getName());
        try {
            config.createNewFile();
        } catch (IOException e) {
        }
    }

    public boolean writeState() {
        try {
            saveData();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private void saveData() throws IOException {
        final HttpURLConnection urlConn = (HttpURLConnection) new URL("http://" + "www.google.com/").openConnection();
        urlConn.setConnectTimeout(1000 * 10);
        final long startTime = System.currentTimeMillis();
        urlConn.connect();
        if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            config.write("PING:" + (System.currentTimeMillis() - startTime), true);
        } else {
            config.write("PING:error", true);
        }
    }

    public static NetworkProfile create(Network n) {
        return new NetworkProfile(n);
    }
}
