package com;



import java.security.MessageDigest;

public class AECUtil {

	public static boolean verifySign(String sign, String appid,String timestamp, String data, String key) {
		try {
			String str= "appid="+appid+"&data="+data+"&timestamp="+timestamp+"&key="+key;
	        //System.out.println("签名字符串:"+str);
			String md5Str = md5(str);
			//System.out.println("md5Sign:"+md5Str);
			return md5Str.equalsIgnoreCase(sign);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public static String sign(String appid,String timestamp, String data, String key) throws Exception {
		return  md5("appid="+appid+"&data="+data+"&timestamp="+timestamp+"&key="+key);
	}
	
	
	 /**
     * 对字符串计算md5
     * @param data
     * @return
     * @throws Exception
     */
    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(data.getBytes("utf-8"));
        String md5str = byte2HexStr(digest, 0, digest.length);
        return md5str;
    } 
    
    
    /**
     * 转成16进制字符串
     * @param data
     * @param offset
     * @param len
     * @return
     */
    public static String byte2HexStr(byte[] data,int offset,int len) {
        StringBuffer sb = new StringBuffer();
       for (int i = offset; i < offset+len; i++) {
           String temp = Integer.toHexString(data[i] & 0xff);
           if (temp.length() == 1)
               temp = "0" + temp;
           sb.append(temp);
       }
       return sb.toString().toLowerCase();
    }

}
