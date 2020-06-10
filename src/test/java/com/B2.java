package com;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class B2 {
	public static void main(String[] args) {
		String sslKeyStorePath = "D:/a/kclient.keystore";
		String sslKeyStorePassword = "123456";
		String sslKeyStoreType = "JKS"; // 密钥库类型，有JKS PKCS12等
		String sslTrustStore = "D:/a/tclient.keystore";
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
        System.out.println("握手成功");
        
       
        
        
	}

}
