package com;//package com.wyb.Controller;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class WeChat {
//
//	public void dodo(HttpServletRequest req, HttpServletResponse resp) {
//		StringBuffer reqXml = new StringBuffer();
// 
///*        reqXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        reqXml.append("<request>");
//        reqXml.append("    <meta>");
//        reqXml.append("    <channeltype>001</channeltype> ");
//        reqXml.append("    <reqserialno>02340385038080</reqserialno>");
//        reqXml.append("    <trancode>DX001</trancode>");
//        reqXml.append("    <sourceid>10</sourceid>");
//        reqXml.append("</meta>");
//        reqXml.append("<data>");
//        reqXml.append("    <channeltype>001</channeltype>");
//        reqXml.append("    <username>gjjxc</username>   ");
//        reqXml.append("<password>gjjxc</password>  ");
//        reqXml.append("    <phone>18662536750</phone>");
//        reqXml.append("<content>测试</content>");
//        reqXml.append("</data>");
//        reqXml.append("</request>");*/
//InputStream input = this.getClass().getClassLoader().getResourceAsStream("message.txt");
//BufferedReader reqReader = new BufferedReader(new InputStreamReader(input,"utf-8"));
//String line2 = null;
//while((line2 = reqReader.readLine()) != null){
//reqXml.append(line2); 
//}
//reqReader.close();
//URL url = new URL("http://localhost:8080/SMSPLANT/testServlet");
//HttpURLConnection uc = (HttpURLConnection)url.openConnection();
//uc.setConnectTimeout(10000);
//uc.setReadTimeout(120000);
//uc.setRequestMethod("POST");
////      uc.setRequestProperty("Pragma:", "no-cache");
////      uc.setRequestProperty("Cache-Control", "no-cache");
////      uc.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
//uc.setDoOutput(true);
//OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(),"utf-8");
//System.out.println("客户端发送xml:"+reqXml.toString());
//out.write(reqXml.toString());
//out.flush();
//out.close();
//int state = uc.getResponseCode();
//if(state == 200){
////获取返回数据
//BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
//String line = null;
//StringBuffer con = new StringBuffer();
//while((line = in.readLine()) != null){
////line为返回值，这就可以判断是否成功、
//con.append(line); 
//}
//System.out.println("客户端接收xml:"+con.toString());
//in.close();
//resp.sendRedirect("http://www.baidu.com");
//        }
//	}
//
//}
