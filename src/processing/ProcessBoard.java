package processing;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProcessBoard {

    private static JFrame frame;
    private static JPanel panel;

    private static boolean enabled = false;

    private static HashMap<String, String> strings;
    private static HashMap<String, Integer> integers;
    private static HashMap<String, Double> doubles;
    private static HashMap<String, Boolean> booleans;

    private static ArrayList<Component> comps;

    private ProcessBoard() {
    }

    public static void init() {
        strings = new HashMap<>();
        integers = new HashMap<>();
        doubles = new HashMap<>();
        booleans = new HashMap<>();
        comps = new ArrayList<>();
        
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Process Board");
        frame.setLayout(new GridLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(false);
    }

    private static void update() {
        if (enabled) {
            panel.removeAll();
            comps.clear();
            for (String s : strings.keySet()) {
                comps.add(new JLabel(s + ": " + strings.get(s)));
            }

            for (String s : integers.keySet()) {
                comps.add(new JLabel(s + ": " + integers.get(s)));
            }

            for (String s : doubles.keySet()) {
                comps.add(new JLabel(s + ": " + doubles.get(s)));
            }

            for (String s : booleans.keySet()) {
                comps.add(new JLabel(s + ": " + booleans.get(s)));
            }

            
            for (Component c : comps) {
                if (c != null) {
                    panel.add(c);
                }
            }
            panel.revalidate();
            frame.validate();
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
