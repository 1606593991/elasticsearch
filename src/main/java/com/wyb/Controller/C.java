package com.wyb.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.alibaba.fastjson.JSONObject;




public class C {
	
	public static void main(String[] args) throws Exception {
		File f=new File("D:\\cert\\FRXX_YZXX_4501000000002018112600002.xml");
		String str = readtxtContent(f);
		System.out.println(str);
//		post("https://121.22.111.251:9008/api/collect/legal","");
	}
	
	public static String readtxtContent(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"gb2312"));  
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


	public static void post(String httpsUrl, String xmlStr) {
		String sslKeyStorePath = "D:/cert/fri_server.cer";
		String sslKeyStorePassword = "123456";
		String sslKeyStoreType = "JKS"; // 密钥库类型，有JKS PKCS12等
		String sslTrustStore = "D:/cert/xz_client.cer";
		String sslTrustStorePassword = "123456";

		System.setProperty("javax.net.ssl.keyStore", sslKeyStorePath);
		System.setProperty("javax.net.ssl.keyStorePassword",
				sslKeyStorePassword);
		System.setProperty("javax.net.ssl.keyStoreType", sslKeyStoreType);
		// 设置系统参数
		System.setProperty("javax.net.ssl.trustStore", sslTrustStore);
		System.setProperty("javax.net.ssl.trustStorePassword",
				sslTrustStorePassword);

		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		System.setProperty("java.protocol.handler.pkgs", "sun.net.www.protocol");
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		HttpsURLConnection urlCon = null;
		try {
			urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
			urlCon.setDefaultHostnameVerifier(hv);
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("Content-Length",
					String.valueOf(xmlStr.getBytes().length));
			urlCon.setUseCaches(false);
			// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
			urlCon.getOutputStream().write(xmlStr.getBytes("gbk"));
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlCon.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    
}
