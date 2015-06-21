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

    /**
     * Initialize the <code>ProcessBoard</code>. Must be called first.
     */
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

    /**
     * Set the <code>ProcessBoard</code>'s default close operation. Will throw <code>IllefalArgumentException</code> if not a JFrame constant.
     *
     * @param closeOperation The close operation <code>int</code> constant.s
     */
    public static void setCloseOperation(int closeOperation) {
        if (closeOperation != JFrame.DO_NOTHING_ON_CLOSE
                && closeOperation != JFrame.HIDE_ON_CLOSE
                && closeOperation != JFrame.DISPOSE_ON_CLOSE
                && closeOperation != JFrame.EXIT_ON_CLOSE) {
            throw new IllegalArgumentException("Not a valid close operation.");
        }

        frame.setDefaultCloseOperation(closeOperation);
    }

    /**
     * Set the size of the <code>ProcessBoard</code>.
     *
     * @param width Width.
     * @param height Height.
     */
    public static void setSize(int width, int height) {
        frame.setSize(width, height);
    }

    public static void clearAll(boolean clearComps) {
        strings.clear();
        integers.clear();
        doubles.clear();
        booleans.clear();
        if (clearComps) {
            comps.clear();
        }
        update();
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

    /**
     * Enable the <code>ProcessBoard</code>. Refreshes the board and shows it.
     */
    public static synchronized void enable() {
        enabled = true;
        update();
    }

    /**
     * Disables the <code>ProcessBoard</code>. Refreshes the board and hides it.
     */
    public static synchronized void disable() {
        enabled = false;
        update();
    }

    /**
     * Get whether or not the board is enabled.
     *
     * @return True if enabled.
     */
    public static synchronized boolean isEnabled() {
        return enabled;
    }

    /**
     * Put a string onto the board.
     *
     * @see java.util.HashMap
     * @param key Key
     * @param value String value
     */
    public static synchronized void putString(String key, String value) {
        strings.put(key, value);
        update();
    }

    /**
     * Get a string from the board.
     *
     * @param key Key
     * @return String value
     */
    public static synchronized String getString(String key) {
        return strings.get(key);

    }

    /**
     * Put an int onto the board.
     *
     * @see java.util.HashMap
     * @param key Key
     * @param value Int value
     */
    public static synchronized void putInt(String key, int value) {
        integers.put(key, value);
        update();
    }

    /**
     * Get an int from the board.
     *
     * @param key Key
     * @return Int value
     */
    public static synchronized int getInt(String key) {
        return integers.get(key);
    }

    /**
     * Put a double onto the board.
     *
     * @param key Key
     * @param value Double value
     */
    public static synchronized void putDouble(String key, double value) {
        doubles.put(key, value);
        update();
    }

    /**
     * Get an double from the board.
     *
     * @param key Key
     * @return Double value
     */
    public static synchronized double getDouble(String key) {
        return doubles.get(key);
    }

    /**
     * Put a boolean onto the board.
     *
     * @param key Key
     * @param value Boolean value
     */
    public static synchronized void putBoolean(String key, boolean value) {
        booleans.put(key, value);
        update();
    }

    /**
     * Get a boolean from the board.
     *
     * @param key Key
     * @return Boolean value
     */
    public static synchronized boolean getBoolean(String key) {
        return booleans.get(key);
    }

    public static synchronized void putComponent(Component c) {
        frame.add(c);
    }
}
