package com;

public class T{
	public static void main(String[] args) throws Exception {
		String key="a23e5fg812g45mg0";
		String data = "948824AEBAE596ECADA92FEC340C3456517097CC80A476BD8BFA13EE701BEB74";
		Aec aec1 = Aec.getInstance(key);
		String decData = aec1.decryptor(data);
		System.out.println("decData:"+decData);

		String timestamp=System.currentTimeMillis()/1000+"";


       Aec aec = Aec.getInstance(key);
       System.out.println(aec.encrytor(key));
       System.out.println(aec.decryptor("948824AEBAE596ECADA92FEC340C3456517097CC80A476BD8BFA13EE701BEB74"));
		System.out.println(timestamp);
		String appid="450102000001";
		String str= "appid="+appid+"&data="+data+"&timestamp="+timestamp+"&key="+key;
        //System.out.println("签名字符串:"+str);
		String md5Str = AECUtil.md5(str);
		
		System.out.println(md5Str);
	}
}
