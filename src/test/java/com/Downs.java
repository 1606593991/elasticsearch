package com;//package com.wyb.Controller;
//
//import java.io.ByteArrayInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import org.apache.http.HttpHeaders;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class Downs {
//	String url = "http://restAddr/project/service/download1/kaola";
//	String filePath = "E:/fileServer/client/download/kaola.jpg";
//	
//	InputStream inputStream = null;
//	OutputStream outputStream = null;
//			
//	RestTemplate restTemplate = new RestTemplate();
//	try {
//		//		Object result = restTemplate.getForObject(url, Object.class);
//		HttpHeaders headers = new HttpHeaders();
//		ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
//		byte[] result = response.getBody();
//		inputStream = new ByteArrayInputStream(result);
//		
//		outputStream = new FileOutputStream(new File(filePath));
//		
//		int len = 0;
//		byte[] buf = new byte[1024];
//		while ((len = inputStream.read(buf, 0, 1024)) != -1) {
//			outputStream.write(buf, 0, len);
//		}
//		outputStream.flush();
//	} catch (Exception e) {
//		e.printStackTrace();
//
//	} finally {
//		try {
//			if(inputStream != null) inputStream.close();
//			if(outputStream != null) outputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.err.println("数据流关闭异常！");
//		}
//	}
//	
//	return "success";
//}
//
//}
