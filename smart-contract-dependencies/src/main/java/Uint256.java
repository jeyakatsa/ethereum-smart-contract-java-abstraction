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
import javax.xml.bind.DatatypeConverter;

public interface Uint256 {

    public static String decrypt(char[] encryptedText) throws Exception {

        byte[] saltBytes = salt.getBytes("UTF-8");
        byte[] encryptedTextBytes = DatatypeConverter.parseBase64Binary(encryptedText.toString());

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(encryptedText, saltBytes, iterations, keySize);
        SecretKey secretkey = skf.generateSecret(spec);
        SecretKeySpec secretSpec = new SecretKeySpec(secretkey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));

        byte[] decryptedTextBytes = null;

        try {
            decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
        }   catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }   catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return decryptedTextBytes.toString();

    }

}
