package system;

public class Natives {

    public native String nativeFoo();

    static {
        System.loadLibrary("foo");
    }

    public void print() {
        String str = nativeFoo();
        System.out.println(str);
    }

    public static void main(String[] args) {
        (new Natives()).print();
    }
}
