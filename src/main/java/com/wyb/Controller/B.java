package com.wyb.Controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyb.util.GetSeal;

@RequestMapping("/a")
public class B {
	@RequestMapping("/b/{id}")
	public String bs() throws Exception {
		 String appid = "GZABCKZ";
		 String Key = "SASKEYSSA";
		 long timestamp = System.currentTimeMillis() / 1000;
		 GetSeal g=new GetSeal();
//		 g.setAreaCode("450100");
		 g.setQueryParam("4501024400006");
//		 g.setType("2");
		 String s = JSON.toJSONString(g);
		 Aec aec2 = Aec.getInstance(Key);
		 String dataok = aec2.encrytor(s);	 
//		 String ss11 = aec2.decryptor("DFE22B09135D2ED024AAD2EE60B620B9078FDDCB9B138092EBA46289ABCEE402A8A2636C8EEA1658DD74DC1752758239C690FCCDEE416E939BD8954428F8877DC02CC246D7BCA2841258DCA563AD558F0CC4AB86441FB1D8E5341F9110F7EA8EEEFF869D2F793930BFF5E3B2626264F66CD59F3193100A44FD60BC3E1191DCD3A81A3DBDA90D59150D5A988BEEA8DC657E79AEF76782593A4B4843E27EA3478C4879B24BB7518D22DF0D3F539201A0B99FCD2914FCC060FCA70A02D7D15BE06CB362603E55C60E9B6CEBF71FAB2EE0C4714DCCA7AF3250A5C9DC8FD01CEB1CDD67FA5108F51DC04B80E4A7A8A82903352573E9623DA4BCCDBF1C9571604C4961CE58573429D4DF0DCFA429501C8021B43689D53F34B7FFAC55DE4BF85E274E987AA1063501D5A47D75793CCEC0620EADE0451920ED34BE0A29A131321B15EE29D8B3012A5FBB02D6777E3FE64FB7C4F93F88313FBDE50DB835E02B8B9470D543532A59EBF89BA739AFFCA474D1A538E5B8B0992D52CD6ECE2032C4FFA1E463A6A057901A89A14D54AA53CC7C69541172F19C4F362AEDFB22FF6AE9784491F3FC4528BA65C1D096ADA6A6991050140F2F59A811C2C82B534499169C28BD9E1B70846E46F942C2514F387E87BF910F633F510C57308BAFCD06ACE66565D7D4BBB820E18187941805D7D425281A7E9DC6AE9D22D8059150B96D2E1633F4D3E93A1C5FAE36E1ECBAE3DAC44ED355FEE850B21379BF17E47636F47C89709C5D1743715461B90F941FE217FFBFB923766619DCFFB7EB0C0061108F874513D4EE69FFB04C688F0C49682392AAECB880CDD83D0497119919B071D08490B567FFB2AF22038627A4B128EB7B51BAF9D998A4CBADFE737B7284F0C1A84B1481629D0B0FCC234EE575DBD0696902FF9EC30E891F33388FE9E50374ECF6A1B7B60C14380CCD45C20FFBFCC814F4C5E07835B32CA350CFA64F4713C84FE97E79A65452668919ADB9E3F8802005EBD15F0EBF91A5D9760BEF51E83FAEC5ABB071CF56126AE2005D0EC9551062686F5FFD2B0303724428D0424997F4C51176EAA5574E2CAD535DFAE19DD02315118F5E8DBC47358B06683075A1B94C95E29277696B9B6BBA6182699922CDD80F62F440227EDEB10CF89ADB35D98D953BC5251ADC01215DE427F3BC1E8BB6F565D73F4D3BBDA3DB1A58DA70225DC2B4CA17E5E749BE92BCD481F43E028854C9B3797331438022F0D70249BE5EC64A95DCC62128F90856B34F623C31");
//		  System.out.println(ss11);
		 String Sign = AECUtil.sign(appid, String.valueOf(timestamp), dataok, Key);
		 System.out.println(timestamp);
		 System.out.println(Sign);
		 System.out.println(dataok);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://192.168.1.213:8586/s/api/sealinfo/getSealinfo";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("appId", "GZABCKZ");
		jsonObj.put("data", "1");
		jsonObj.put("sign", "203f624f433454df67c5b6e0cb7055d6");
		jsonObj.put("timestamp", new Date().getTime());
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, JSONObject.class);
		System.out.println(exchange.getBody());
		return exchange.getBody().toJSONString();
	}

	
	public static void main(String[] args) throws Exception {
		String abc="{\"is_subscribe\":\"N\",\"appid\":\"wx9c701884571e069a\",\"fee_type\":\"CNY\",\"nonce_str\":\"10704a2669fe4116a6249ddd0357c1cd\",\"out_trade_no\":\"4566015002910W323\",\"transaction_id\":\"4200000268201904163335079818\",\"trade_type\":\"NATIVE\",\"sign\":\"E717EF8ED9388275A34889D5D48FEBBF03C997192BD4CC5772FEC0C8C573B7E7\",\"result_code\":\"SUCCESS\",\"mch_id\":\"1493308332\",\"total_fee\":\"1\",\"attach\":\"B套餐\",\"time_end\":\"20190416174510\",\"openid\":\"oPdgT0ZMYSS4HvEju96UBMu9GT5g\",\"bank_type\":\"ABC_DEBIT\",\"return_code\":\"SUCCESS\",\"cash_fee\":\"1\"}";
		load("http://192.168.1.125:8080/s/order/weixin/notify.htm",abc);
//		 String appid = "GZABCKZ";
//		 String Key = "SASKEYSSA";
//		 long timestamp = System.currentTimeMillis() / 1000;
//		 GetSeal g=new GetSeal();
////		 g.setAreaCode("450100");
//		 g.setQueryParam("4201010004923");
//		 g.setType("3");
//		RestTemplate restTemplate = new RestTemplate();
//		 String s = JSON.toJSONString(g);
//		 Aec aec2 = Aec.getInstance(Key);
//		 String data = aec2.encrytor(s);	
//		 String sign = AECUtil.sign(appid, String.valueOf(timestamp), data, Key);
//		 
//		 HttpHeaders headers = new HttpHeaders();
//		 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		 MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//		 map.add("data",data);
//		 map.add("appId", "GZABCKZ");
//		 map.add("sign", sign);
//		 map.add("timestamp", timestamp+"");
//		 String url = "http://192.168.1.213:8586/s/api/sealinfo/getSealinfo";
//		 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//		 ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
////     	byte[] result = response.getBody();
////		ByteArrayInputStream inputStream = new ByteArrayInputStream(result);
//		System.out.println(response.getBody());
//		FileOutputStream outputStream = new FileOutputStream(new File("d:\\abc\\123123.zip"));
//		int len = 0;
//		byte[] buf = new byte[1024];
//		while ((len = inputStream.read(buf, 0, 1024)) != -1) {
//			outputStream.write(buf, 0, len);
//		}
//		outputStream.flush();
//		outputStream.close();
//		inputStream.close();
	}
	
	 public static String load(String url,String query) throws Exception
	    {
	        URL restURL = new URL(url);
	        /*
	         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
	         */
	        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
	        //请求方式
	        conn.setRequestMethod("POST");
	        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
	        conn.setDoOutput(true);
	        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
	        conn.setAllowUserInteraction(false);

	        PrintStream ps = new PrintStream(conn.getOutputStream());
	        ps.print(query);

	        ps.close();

	        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line,resultStr="";

	        while(null != (line=bReader.readLine()))
	        {
	        resultStr +=line;
	        }
	        System.out.println("3412412---"+resultStr);
	        bReader.close();

	        return resultStr;

	    }
	
	
}
