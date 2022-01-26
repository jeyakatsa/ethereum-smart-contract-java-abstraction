import java.util.*;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public interface Uint256 {

    static byte[] ivBytes = new byte[0];
    static int iterations = 65536;
    static int keySize = 256;

    public default void Uint256(String decrypt) {

    };

    public static String decrypt(byte[] uint) throws Exception {

        char[] placeholderText = new char[0];

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(placeholderText, uint, iterations, keySize);
        SecretKey secretkey = skf.generateSecret(spec);
        SecretKeySpec secretSpec = new SecretKeySpec(secretkey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));

        byte[] decryptedTextBytes = null;

        try {
            decryptedTextBytes = cipher.doFinal();
        }   catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }   catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return decryptedTextBytes.toString();

    }

}
