package math.encryption;

public class M1 {
    private M1() {
    }
    
    public static String hash(String base) {
        String encrypted = "";
        for (int x = 0; x < base.length(); x++) {
            encrypted += (char) (((base.charAt(x) & 0xff) * base.length()) / (base.length() % 2 == 0 ? 11 : 3));
        }
        return encrypted;
    }
    
    public static String doubleHash(String base) {
        return hash(hash(base));
    }
}
