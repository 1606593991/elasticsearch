package com;//package com.wyb.Controller;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.URL;
//import java.net.URLConnection;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import org.dom4j.Attribute;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.XMLWriter;
//import org.skyscreamer.jsonassert.JSONParser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.wyb.model.ResponseBean;
//import com.wyb.util.HttpRequestForJosn;
//
//@Controller
//@RestController
//public class HelloController {
//	
//	public static void main(String[] args) throws Exception {
//		
//		String str="630000_BADWXX_20150530_001.zip";
//		String a[]=str.split(".");
//		System.out.println(a[0]);
////		FILE FILE =NEW FILE("D:/XML/1.XML");
////		SAXCREATE(FILE);
////	    String param="{\"yzbm\":\"4501000475936\",\"yzmc\":\"南宁市天测科技仪器开发有限责任公司发票专用章\",\"yzxtdm\":\"椭圆\",\"yzztdm\":\"1\",\"yzsydwbm\":\"430000000000\",\"yzbajgbm\":null,\"yzzzdwbm\":\"450100000003\",\"yzlxdm\":\"03\",\"zcdm\":\"08\",\"yysm_jyqk\":null,\"jbr_xm\":\"吉宁珍\",\"jbr_zjhm\":\"450106540710102\",\"jbr_cyzjdm\":\"0\",\"jbr_lxdh\":null,\"hyr_xm\":\"0001\",\"yzhyrq\":\"19990910\",\"cjrq\":null,\"zzrq\":null,\"jfrq\":null,\"bfrq\":null,\"jxrq\":null,\"gsrq\":null,\"yztxkd_xsz\":0,\"yztxgd_xsz\":0,\"yztxsfys_pdbz\":null,\"swywtxsj\":\"\",\"swywtx_dzwjmc\":\"\",\"zmxzdm\":null,\"dzywtx_dzwjmc\":\"\",\"dzywtxsj\":\"\",\"dzywwfzsbtztx_dzwjmc\":\"\",\"dzywwfzsbtztxsj\":\"\",\"qzr_xm\":null,\"qzr_cyzjdm\":\"0\",\"qzr_zjhm\":null,\"qzfs\":\"0\",\"dzmc\":null,\"txdz\":null,\"yxzmcc\":\"35*25\",\"yzxpbm\":null,\"yzkzlbdm\":\"0\",\"yzbacllxdm\":\"\",\"czzt\":\"0\",\"gxsj\":936892800000,\"sjgsdwmc\":null,\"sjgsdwdm\":null}";
////
////        String url = "http://101.230.3.119:17022/qggz-acc/YZXX";
////		sendPost(url,param);
//		 String param="{ \"yzlxdm\": \"03\"}";
//        JSONObject json = new JSONObject();
//        json.put("age", 18);
//        json.put("name", "小芳");
//        json.put("address", "广东深圳");
//        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
////        String url = "http://localhost:9999/test/object";
////        String url = "http://localhost:9999/test/map";
//         JSONObject    jsonObject = JSONObject.parseObject(param); 
//        String url = "http://101.230.3.119:17022/qggz-acc/YZXX";
//        String result = restTemplate.postForObject(url, jsonObject, String.class);
//        System.out.println(result);
//        
//        
//	}
//	
//	
//	
//	
//	
//	public static String sendPost(String url, String param) {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("[POST请求]向地址：" + url + " 发送数据：" + param + " 发生错误!");
//        } finally {// 使用finally块来关闭输出流、输入流
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch (IOException ex) {
//                System.out.println("关闭流异常");
//            }
//        }
//        System.out.print(result);
//        return result;
//    }
//
//	
//	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
//	protected static String postForMapParam() {
//	        PrintWriter out = null;
//	        BufferedReader in = null;
//	        String result = "";
//		    String param="{\"sealAreacode\":\"450100\",\"sealAuditorStatut\":1,\"sealAuditperson\":\"0001\",\"sealAudittime\":\"19990910\",\"sealCode\":\"4501000475935\",\"sealCreatedate\":936892800000,\"sealDataversion\":2,\"sealDeliveridtype\":0,\"sealDeliverstatus\":0,\"sealEidtype\":0,\"sealEkeytype\":1,\"sealEsealstatus\":0,\"sealExt1\":\"0\",\"sealExt3\":\"0\",\"sealMatelcode\":\"08\",\"sealName\":\"南宁市新蕾幼儿园发票专用章\",\"sealOffCheckStatus\":12,\"sealPrintreason\":0,\"sealPrintstatus\":0,\"sealPunitcode\":\"450100000003\",\"sealRecordCheckStatus\":0,\"sealRecordstatus\":0,\"sealSealimg\":-1,\"sealShapecode\":\"椭圆\",\"sealSize\":\"35*25\",\"sealStatuscode\":\"1\",\"sealStypecode\":\"03\",\"sealTranstatus\":1,\"sealType\":1,\"sealUndertaker\":\"吉宁珍\",\"sealUpdatedate\":936892800000,\"sealUpdatetime\":\"\",\"sealUtakerid\":\"450106540710102\",\"sealUtakeridtype\":0}";
//
//	        String url = "http://101.230.3.119:17022/qggz-acc/YZXX";
//	        try {
//	            URL realUrl = new URL(url);
//	            // 打开和URL之间的连接
//	            URLConnection conn = realUrl.openConnection();
//	            // 设置通用的请求属性
//	            conn.setRequestProperty("accept", "*/*");
//	            conn.setRequestProperty("connection", "Keep-Alive");
//	            conn.setRequestProperty("user-agent",
//	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//	            // 发送POST请求必须设置如下两行
//	            conn.setDoOutput(true);
//	            conn.setDoInput(true);
//	            // 获取URLConnection对象对应的输出流
//	            out = new PrintWriter(conn.getOutputStream());
//	            // 发送请求参数
//	            out.print(param);
//	            // flush输出流的缓冲
//	            out.flush();
//	            // 定义BufferedReader输入流来读取URL的响应
//	            in = new BufferedReader(
//	                    new InputStreamReader(conn.getInputStream()));
//	            String line;
//	            while ((line = in.readLine()) != null) {
//	                result += line;
//	            }
//	        } catch (Exception e) {
//	            System.out.println("发送 POST 请求出现异常！"+e);
//	            e.printStackTrace();
//	        }
//	        //使用finally块来关闭输出流、输入流
//	        finally{
//	            try{
//	                if(out!=null){
//	                    out.close();
//	                }
//	                if(in!=null){
//	                    in.close();
//	                }
//	            }
//	            catch(IOException ex){
//	                ex.printStackTrace();
//	            }
//	        }
//	        System.out.println(result);
//	        return result;
//	  
//		
//		
//		//		 JSONObject json = new JSONObject();
////	        json.put("age", 18);
////	        json.put("name", "小芳");
////	        json.put("address", "广东深圳");
////	        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
//////	        String url = "http://localhost:9999/test/object";
//////	        String url = "http://localhost:9999/test/map";
////	        String json2="{\"sealAreacode\":\"450100\",\"sealAuditorStatut\":1,\"sealAuditperson\":\"0001\",\"sealAudittime\":\"19990910\",\"sealCode\":\"4501000475935\",\"sealCreatedate\":936892800000,\"sealDataversion\":2,\"sealDeliveridtype\":0,\"sealDeliverstatus\":0,\"sealEidtype\":0,\"sealEkeytype\":1,\"sealEsealstatus\":0,\"sealExt1\":\"0\",\"sealExt3\":\"0\",\"sealMatelcode\":\"08\",\"sealName\":\"南宁市新蕾幼儿园发票专用章\",\"sealOffCheckStatus\":12,\"sealPrintreason\":0,\"sealPrintstatus\":0,\"sealPunitcode\":\"450100000003\",\"sealRecordCheckStatus\":0,\"sealRecordstatus\":0,\"sealSealimg\":-1,\"sealShapecode\":\"椭圆\",\"sealSize\":\"35*25\",\"sealStatuscode\":\"1\",\"sealStypecode\":\"03\",\"sealTranstatus\":1,\"sealType\":1,\"sealUndertaker\":\"吉宁珍\",\"sealUpdatedate\":936892800000,\"sealUpdatetime\":\"\",\"sealUtakerid\":\"450106540710102\",\"sealUtakeridtype\":0}";
////	        String url = "http://101.230.3.119:17022/qggz-acc/YZXX";
////	        String result = restTemplate.postForObject(url, json, String.class);
////	        System.out.println(result);
////	        ResponseBean r=new ResponseBean();
////	    	int a=(int)(1+Math.random()*(10-1+1));
////			if (a >= 5) {
////				r.setCode("000");
////				r.setMsg("处理成功");
////			} else {
////				r.setCode("002");
////				r.setMsg("JSON解析失败");
////			}
////			r.setData((String)queryParam);
//	  
////	    
//	}
//	@Autowired
//	protected static RestTemplate restTemplate;
//	 public static void SAXcreate(File file)throws Exception {
//    	 org.dom4j.Document document=DocumentHelper.createDocument();
//         org.dom4j.Element Package=document.addElement("Package");
//         Package.addAttribute("version", "1.0");
//         org.dom4j.Element PackageHead=Package.addElement("PackageHead");
//         org.dom4j.Element BBH=PackageHead.addElement("BBH");
//         BBH.setText("1.00");
//         org.dom4j.Element DWDM=PackageHead.addElement("DWDM");
//         DWDM.setText("DWDM");
//         org.dom4j.Element DWMC=PackageHead.addElement("DWMC");
//         DWMC.setText("DWMC");
//         org.dom4j.Element JLS=PackageHead.addElement("JLS");
//         JLS.setText("JLS");
//         org.dom4j.Element SCRQ=PackageHead.addElement("SCRQ");
//         SCRQ.setText("SCRQ");
//         org.dom4j.Element SJBBH=PackageHead.addElement("SJBBH");
//         SJBBH.setText("SJBBH");
//         org.dom4j.Element Data=Package.addElement("Data");
//         
//         org.dom4j.Element Record=Data.addElement("Record");
//         Element attribute = Record.addAttribute("index", "1");
//         org.dom4j.Element Qyjbxx=Record.addElement("Qyjbxx");         
////         使用单位信息
//         org.dom4j.Element tyshxydm=Qyjbxx.addElement("tyshxydm");
//         tyshxydm.setText("统一社会信用代码");
//         org.dom4j.Element yzsydwbm=Qyjbxx.addElement("yzsydwbm");
//         yzsydwbm.setText("印章使用单位编码");
//         org.dom4j.Element dwmc=Qyjbxx.addElement("dwmc");
//         dwmc.setText("单位名称");
//         org.dom4j.Element dwssmzwzmc=Qyjbxx.addElement("dwssmzwzmc");
//         dwssmzwzmc.setText("单位少数民族文字名称");
//         org.dom4j.Element dwywmc=Qyjbxx.addElement("dwywmc");
//         dwywmc.setText("单位英文名称");
//         org.dom4j.Element dwywsx=Qyjbxx.addElement("dwywsx");
//         dwywsx.setText("单位英文缩写");
//         org.dom4j.Element yzspdwlxdm=Qyjbxx.addElement("yzspdwlxdm");
//         yzspdwlxdm.setText("印章使用单位类型代码");
//         org.dom4j.Element dwdz_ssxqdm=Qyjbxx.addElement("dwdz_ssxqdm");
//         dwdz_ssxqdm.setText("单位地址省市县（区）");
//         org.dom4j.Element fddbr_xm=Qyjbxx.addElement("fddbr_xm");
//         fddbr_xm.setText("法定代表人姓名");
//         org.dom4j.Element fddbr_cyzjdm=Qyjbxx.addElement("fddbr_cyzjdm");
//         fddbr_cyzjdm.setText("法定代表人证件种类");
//         org.dom4j.Element fddbr_zjhm=Qyjbxx.addElement("fddbr_zjhm");
//         fddbr_zjhm.setText("法定代表人证件号码");
//         org.dom4j.Element fddbr_lxdh=Qyjbxx.addElement("fddbr_lxdh");
//         fddbr_lxdh.setText("法定代表人联系电话");
//         org.dom4j.Element dwdz_qhnxxdz=Qyjbxx.addElement("dwdz_qhnxxdz");
//         dwdz_qhnxxdz.setText("单位地址（区划内详细地址）");
//         org.dom4j.Element yzbm1=Qyjbxx.addElement("yzbm");
//         yzbm1.setText("邮政编码");
//         org.dom4j.Element lxdh=Qyjbxx.addElement("lxdh");
//         lxdh.setText("联系电话");
//         org.dom4j.Element yzspdwbm=Qyjbxx.addElement("yzspdwbm");
//         yzspdwbm.setText("备案单位编码");
//         org.dom4j.Element cjsj=Qyjbxx.addElement("cjsj");
//         cjsj.setText("创建时间");
//         org.dom4j.Element Qyztdm=Qyjbxx.addElement("Qyztdm");
//         Qyztdm.setText("企业状态");
//         org.dom4j.Element Czsj=Qyjbxx.addElement("Czsj");
//         Czsj.setText("操作时间");
//         org.dom4j.Element jyfw=Qyjbxx.addElement("jyfw");
//         jyfw.setText("经营范围");
//         org.dom4j.Element zch=Qyjbxx.addElement("zch");
//         zch.setText("注册号");
//         org.dom4j.Element zcrq=Qyjbxx.addElement("zcrq");
//         zcrq.setText("注册日期");
//         org.dom4j.Element dwjjhy=Qyjbxx.addElement("dwjjhy");
//         dwjjhy.setText("单位经济行业");
//         
//         org.dom4j.Element SealList=Record.addElement("SealList");
//         org.dom4j.Element SealInfo=SealList.addElement("SealInfo");
//         
//         Element SealInfoadd = SealInfo.addAttribute("index", "1");
//         org.dom4j.Element yzbm=SealInfo.addElement("yzbm");
//         yzbm.setText("印章编码");
//         org.dom4j.Element Tyshxydm=SealInfo.addElement("Tyshxydm");
//         Tyshxydm.setText("统一社会信用代码");
//         org.dom4j.Element yzmc=SealInfo.addElement("yzmc");
//         yzmc.setText("印章名称");
//         org.dom4j.Element yzlxdm=SealInfo.addElement("yzlxdm");
//         yzlxdm.setText("印章类型代码");
//         org.dom4j.Element yzzzdwbm=SealInfo.addElement("yzzzdwbm");
//         yzzzdwbm.setText("印章制作单位编码");
//         org.dom4j.Element yzspdwbm2=SealInfo.addElement("yzspdwbm");
//         yzspdwbm2.setText("印章备案单位编码");
//         org.dom4j.Element Sfyxxp=SealInfo.addElement("Sfyxxp");
//         Sfyxxp.setText("是否已写芯片");
//         org.dom4j.Element Xpbm=SealInfo.addElement("Xpbm");
//         Xpbm.setText("芯片编码");
//         org.dom4j.Element Xpxrsj=SealInfo.addElement("Xpxrsj");
//         Xpxrsj.setText("芯片写入时间");
//         org.dom4j.Element Djr_xm=SealInfo.addElement("Djr_xm");
//         Djr_xm.setText("登记人姓名");
//         org.dom4j.Element Yzztdm=SealInfo.addElement("Yzztdm");
//         Yzztdm.setText("印章状态");
//         org.dom4j.Element Cjsj=SealInfo.addElement("Cjsj");
//         Cjsj.setText("创建时间");
//         org.dom4j.Element Zzycczsj=SealInfo.addElement("Zzycczsj");
//         Zzycczsj.setText("最近一次操作时间");
//         org.dom4j.Element Sfydzz=SealInfo.addElement("Sfydzz");
//         Sfydzz.setText("是否有电子章");
//         org.dom4j.Element dzzsl=SealInfo.addElement("dzzsl");
//         dzzsl.setText("电子章数量");
//         org.dom4j.Element jbr_xm=SealInfo.addElement("jbr_xm");
//         jbr_xm.setText("经办人_姓名");
//         org.dom4j.Element jbr_cyzjdm=SealInfo.addElement("jbr_cyzjdm");
//         jbr_cyzjdm.setText("经办人_证件类型");
//         org.dom4j.Element jbr_gmsfhm=SealInfo.addElement("jbr_gmsfhm");
//         jbr_gmsfhm.setText("经办人_公民身份证号码");
//         org.dom4j.Element jbr_lxdh=SealInfo.addElement("jbr_lxdh");
//         jbr_lxdh.setText("经办人_联系电话");
//         org.dom4j.Element Cyry_xm=SealInfo.addElement("Cyry_xm");
//         Cyry_xm.setText("制章从业人员_姓名");
//         org.dom4j.Element Cyry_gmsfhm=SealInfo.addElement("Cyry_gmsfhm");
//         Cyry_gmsfhm.setText("制章从业人员_公民身份证号码");
//         org.dom4j.Element Cyry_lxdh=SealInfo.addElement("Cyry_lxdh");
//         Cyry_lxdh.setText("制章从业人员_联系电话");
//         org.dom4j.Element Qzr_xm=SealInfo.addElement("Qzr_xm");
//         Qzr_xm.setText("取章人姓名");
//         org.dom4j.Element Qzr_cyzjdm=SealInfo.addElement("Qzr_cyzjdm");
//         Qzr_cyzjdm.setText("取章人证件类型");
//         org.dom4j.Element Qzr_lxdh=SealInfo.addElement("Qzr_lxdh");
//         Qzr_lxdh.setText("取章人_联系电话");
//         
//         XMLWriter writer=new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
//         writer.setEscapeText(false);//字符是否转义,默认true
//         writer.write(document);
//         writer.close();
//    }
//
//	
//	
//
//}
