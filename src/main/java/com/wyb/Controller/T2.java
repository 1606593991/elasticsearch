package com.wyb.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class T2 {
	 public static String Encrypt(String strSrc) {
         MessageDigest md = null;
         String strDes = null;
         byte[] bt = strSrc.getBytes();
         try {
             md = MessageDigest.getInstance("SHA-256");
             md.update(bt);
             strDes = bytes2Hex(md.digest()); // to HexString
         } catch (NoSuchAlgorithmException e) {
             System.out.println("签名失败！");
             return null;
         }
         return strDes.toUpperCase();
     }
     public static String bytes2Hex(byte[] bts) {
         String des = "";
         String tmp = null;
         for (int i = 0; i < bts.length; i++) {
             tmp = (Integer.toHexString(bts[i] & 0xFF));
             if (tmp.length() == 1) {
                 des += "0";
             }
             des += tmp;
         }
         return des;
     }
 	public static void main(String[] args) {
     
    	   long timestampNow=System.currentTimeMillis();
 	      String timestamp = timestampNow+"";
 			String uid= "ab570e0a:015a1d0fbef0:00cb3d";
 			String appSecret ="http://www.gxxzwd.com";
 			String result=Encrypt(timestamp+appSecret+uid+timestamp);
 			
 			System.out.println(timestamp);
 			System.out.println(result);
     }
}
