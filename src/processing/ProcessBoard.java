package processing;

import java.util.HashMap;
import javax.swing.JFrame;

public class ProcessBoard {

    private static JFrame frame;

    private static boolean enabled = false;
    private static boolean init = false;

    private static HashMap<String, String> strings;
    private static HashMap<String, Integer> integers;
    private static HashMap<String, Double> doubles;
    private static HashMap<String, Boolean> booleans;

    private ProcessBoard() {
    }

    public static void init() {
        if (!init) {
            init = true;
            frame = new JFrame();
            frame.setSize(500, 500);
            frame.setTitle("Process Board");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
        }
    }

    private static void update() {
        if (enabled) {
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }

    public static synchronized void enable() {
        enabled = true;
        update();
    }

    public static synchronized void disable() {
        enabled = false;
        update();
    }

    public static synchronized boolean isEnabled() {
        return enabled;
    }

    public static synchronized void putString(String key, String value) {
        strings.put(key, value);
        update();
    }

    public static synchronized String getString(String key) {
        return strings.get(key);

    }

    public static synchronized void putInt(String key, int value) {
        integers.put(key, value);
        update();
    }

    public static synchronized int getInt(String key) {
        return integers.get(key);
    }

    public static synchronized void putDouble(String key, double value) {
        doubles.put(key, value);
        update();
    }

    public static synchronized double getDouble(String key) {
        return doubles.get(key);
    }

    public static synchronized void putBoolean(String key, boolean value) {
        booleans.put(key, value);
        update();
    }

    public static synchronized boolean getBoolean(String key) {
        return booleans.get(key);
    }
}
