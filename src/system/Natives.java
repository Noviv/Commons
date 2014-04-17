package system;

import java.io.File;

public class Natives {

    public native String nativeFoo();

    static {
        File f = new File("src/system/foo.c");
        if (f.exists()) {
            System.load(f.getAbsolutePath());
        } else {
            System.out.println("file no exist");
        }
    }

    public void print() {
        String str = nativeFoo();
        System.out.println(str);
    }

    public static void main(String[] args) {
        (new Natives()).print();
    }
}
