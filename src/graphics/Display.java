package graphics;

import java.awt.Frame;

public class Display {

    private static Frame mine;
    private static boolean created = false;

    public static Frame yours = null;

    private Display() {
    }

    public static void create() {
        created = true;
        mine.setVisible(true);
    }

    public static void setName(String name) {
        mine.setName(name);
    }

    public static void setSize(int width, int height) {
        mine.setSize(width, height);
    }
}
