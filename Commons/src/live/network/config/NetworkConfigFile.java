package live.network.config;

import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;
import live.network.Network;

public class NetworkConfigFile {

    private File file;

    public NetworkConfigFile(Network n) throws IOException {
        file = new File(FileSystemView.getFileSystemView().getHomeDirectory() + n.getName());
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
