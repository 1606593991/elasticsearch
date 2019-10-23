package com.wyb.Controller;
import javax.net.ssl.*;

import java.io.*;
import java.net.URL;
import java.security.KeyStore;

public class HttpsClient {

    private final static String charset = "UTF-8";

    /**
     * 客户端证书设置
     */
    protected static String clientCertPwd="123456";// 客户端证书密码
    protected static String clientCertPath="D:\\cert\\xz_client.cer";
    protected  static String clientKeyType = "JKS";
    /**
     * 服务端证书设置
     */
    protected static String trustCertPath="D:\\cert\\fri_server.cer";
    protected static String truestCertPwd="123456";
    protected static String truestKeyType = "JKS";

    private static SSLContext sslContext=null;

    
    public static void main(String[] args) throws Exception {
    	
    	post("123123","https://121.22.111.251:9008/api/collect/legal");
    }
    
/**
* post方法
*/
    public static Object post(Object request, String requestAddr) {
        String requestData = (String) request;
        StringBuffer sb = null;
        HttpsURLConnection urlCon = null;

        OutputStream os = null;
        InputStream fis = null;
        BufferedInputStream bis = null;

        InputStream is = null;
        BufferedReader br = null;
        try {
            if (sslContext == null) {
                sslContext = SSLContext.getInstance("SSL");
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
                TrustManagerFactory tmf = TrustManagerFactory
                        .getInstance("SunX509");

                KeyStore keyStore = KeyStore.getInstance(clientKeyType);
                keyStore.load(new FileInputStream(clientCertPath),
                        clientCertPwd.toCharArray());
                kmf.init(keyStore, clientCertPwd.toCharArray());

                KeyStore trustKeyStore = KeyStore.getInstance(truestKeyType);
                trustKeyStore.load(new FileInputStream(trustCertPath),
                        truestCertPwd.toCharArray());
                tmf.init(trustKeyStore);
                sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
                HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                    @Override
                    public boolean verify(String arg0, SSLSession arg1) {
                        return true;
                    }
                };
                HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            }

            URL url = new URL(requestAddr);
            urlCon = (HttpsURLConnection) url.openConnection();
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            urlCon.setRequestMethod("POST");
            urlCon.setRequestProperty("Content-type", "text/xml;charset=" + charset);
            urlCon.setSSLSocketFactory(sslContext.getSocketFactory());

            os = urlCon.getOutputStream();
            fis = new ByteArrayInputStream(requestData.getBytes(charset));
            bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = bis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            closeOutputStream(os, fis, bis);

            is = urlCon.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeOutputStream(os, fis, bis);
                closeInputStream(is, br);
                closeUrlCon(urlCon);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "1111";
    }

    /**
     * @param urlCon
     */
    private static void closeUrlCon(HttpsURLConnection urlCon) {
        if (urlCon != null) {
            urlCon.disconnect();
        }
    }

    /**
     * @param is
     * @param br
     * @throws IOException
     */
    private static void closeInputStream(InputStream is, BufferedReader br)
            throws IOException {
        if (br != null) {
            br.close();
        }
        if (is != null) {
            is.close();
        }
    }

    /**
     * @param os
     * @param fis
     * @param bis
     * @throws IOException
     */
    private static void closeOutputStream(OutputStream os, InputStream fis,
                                          BufferedInputStream bis) throws IOException {
        if (os != null) {
            os.flush();
        }
        if (bis != null) {
            bis.close();
        }
        if (fis != null) {
            fis.close();
        }
        if (os != null) {
            os.close();
        }
    }

    public String getTruestCertPwd() {
        return truestCertPwd;
    }

    public void setTruestCertPwd(String truestCertPwd) {
        this.truestCertPwd = truestCertPwd;
    }

    public String getClientCertPwd() {
        return clientCertPwd;
    }

    public void setClientCertPwd(String clientCertPwd) {
        this.clientCertPwd = clientCertPwd;
    }

    public String getClientCertPath() {
        return clientCertPath;
    }

    public void setClientCertPath(String clientCertPath) {
        this.clientCertPath = clientCertPath;
    }

    public String getTrustCertPath() {
        return trustCertPath;
    }

    public void setTrustCertPath(String trustCertPath) {
        this.trustCertPath = trustCertPath;
    }

    public String getTruestKeyType() {
        return truestKeyType;
    }

    public void setTruestKeyType(String truestKeyType) {
        this.truestKeyType = truestKeyType;
    }

    public String getClientKeyType() {
        return clientKeyType;
    }

    public void setClientKeyType(String clientKeyType) {
        this.clientKeyType = clientKeyType;
    }

}
