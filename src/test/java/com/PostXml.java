package com;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostXml {
	

	    static String xml = "<?xml version='1.0' encoding='UTF-8'?><group><name>周成林</name><age>22</age><Image>我们</Image></group>";

	    public static void main(String args[]) {
	        try {

	            CloseableHttpClient httpclient = HttpClients.createDefault();
	            System.out.println(xml);

	            HttpPost httpPost = new HttpPost("http://119.29.85.118//finance.php");          
	            httpPost.addHeader("Content-Type","text/html;charset=UTF-8");

	            //解决中文乱码问题  
	            StringEntity stringEntity = new StringEntity(xml,"UTF-8");
	                stringEntity.setContentEncoding("UTF-8");  

	            httpPost.setEntity(stringEntity);

	            //CloseableHttpResponse response = httpclient.execute(httpPost);




	            System.out.println("Executing request " + httpPost.getRequestLine());

	        //   Create a custom response handler
	            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
	                @Override
	                public String handleResponse(final HttpResponse response)
	                        throws ClientProtocolException, IOException {//                 
	                    int status = response.getStatusLine().getStatusCode();
	                    if (status >= 200 && status < 300) {

	                        HttpEntity entity = response.getEntity();


	                        return entity != null ? EntityUtils.toString(entity) : null;
	                    } else {
	                        throw new ClientProtocolException(
	                                "Unexpected response status: " + status);
	                    }
	                }
	            };          
	            String responseBody = httpclient.execute(httpPost, responseHandler);
	            System.out.println("----------------------------------------");
	            System.out.println(responseBody);

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

