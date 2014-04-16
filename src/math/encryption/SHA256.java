package math.encryption;

import exceptions.MException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Matthew Webb
 */
public class SHA256 {
    private SHA256() {
    }

    /**
     * Hashes a given string with a SHA256 algorithm.
     *
     * @param base The string to be hashed.
     * @return The hashed string.
     * @throws MException Thrown if there is an encoding or algorithm exception.
     */
    public static String hash(String base) throws MException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new MException("Error in SHA256 hashing: " + ex.getMessage());
        }
    }

    /**
     * Double hashes a given string using SHA256.
     *
     * @param toDouble The string to be double hashed.
     * @return The double hashed string.
     * @throws MException Thrown if there is an encoding or algorithm exception.
     */
    public static String doubleHash(String toDouble) throws MException {
        return hash(hash(toDouble));
    }
}
