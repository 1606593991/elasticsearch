package com;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Aec {
	 /** 加密工具 */
    private Cipher encryptCipher = null;
    
    /** 解密工具 */
    private Cipher decryptCipher = null;
    
    public static Aec getInstance(String key) {
        return new Aec(key);
     }

    public Aec(String keyvalue) {
    	
       byte[] arrBTmp = null;
       try {
           arrBTmp = keyvalue.getBytes("GBK");
       } catch (UnsupportedEncodingException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
       byte[] arrB = new byte[16];

       for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
           arrB[i] = arrBTmp[i];
       }
       Key key = new javax.crypto.spec.SecretKeySpec(arrB, "AES");
       
       try {
           encryptCipher = Cipher.getInstance("AES"); 
           encryptCipher.init(Cipher.ENCRYPT_MODE, key);

           decryptCipher = Cipher.getInstance("AES");
           decryptCipher.init(Cipher.DECRYPT_MODE, key);
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       } catch (NoSuchPaddingException e) {
           e.printStackTrace();
       } catch (InvalidKeyException e) {
           e.printStackTrace();
       }
    }

    /**
     * 对字符串加密
     * 
      * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String encrytor(String str) throws InvalidKeyException,IllegalBlockSizeException, BadPaddingException {
       byte[] src = null;
       try {
           src = str.getBytes("utf-8");
       } catch (UnsupportedEncodingException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return parseByte2HexStr(encryptCipher.doFinal(src));
    }

    /**
     * 对字符串解密
     * 
      * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
      * @throws UnsupportedEncodingException 
     */
    public String decryptor(String buff) throws InvalidKeyException,IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
       try {
   	    return new String(decryptCipher.doFinal(parseHexStr2Byte(buff)), "utf-8");
		} catch (Exception e) {
			return "";
		}
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
       if (hexStr.length() < 1)
           return null;
       byte[] result = new byte[hexStr.length() / 2];
       for (int i = 0; i < hexStr.length() / 2; i++) {
           int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
           int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                  16);
           result[i] = (byte) (high * 16 + low);
       }
       return result;
    }

    public static String parseByte2HexStr(byte buf[]) {
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < buf.length; i++) {
           String hex = Integer.toHexString(buf[i] & 0xFF);
           if (hex.length() == 1) {
              hex = '0' + hex;
           }
           sb.append(hex.toUpperCase());
       }
       return sb.toString();
    }
}
