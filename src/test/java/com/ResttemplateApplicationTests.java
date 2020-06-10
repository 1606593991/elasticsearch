package com;//package com.wyb.Controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//import org.springframework.web.client.RestTemplate;
//
//import com.alibaba.fastjson.JSONObject;
//import com.wyb.model.RequestObject;
//
//public class ResttemplateApplicationTests {
//	@Test
//    public void testJavaObj() {
//        RequestObject request = new RequestObject();
//        request.setAge(18);
//        request.setName("小芳");
//        request.setAddress("广东深圳");
//        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
//        String url = "http://localhost:9999/t/object";
////        String url = "http://localhost:9999/test/map";
////        String url = "http://localhost:9999/test/json";
//        String result = restTemplate.postForObject(url, request, String.class);
//        System.out.println(result);
//    }
//
//    @Test
//    public void testMap() {
//        Map<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("age", 18);
//        hashMap.put("name", "小芳");
//        hashMap.put("address", "广东深圳");
//        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
////        String url = "http://localhost:9999/test/object";
//        String url = "http://localhost:9999/t/map";
////        String url = "http://localhost:9999/test/json";
//        String result = restTemplate.postForObject(url, hashMap, String.class);
//        System.out.println(result);
//    }
//
//    @Test
//    public void testJson() {
//        JSONObject json = new JSONObject();
//        json.put("age", 18);
//        json.put("name", "小芳");
//        json.put("address", "广东深圳");
//        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
////        String url = "http://localhost:9999/test/object";
////        String url = "http://localhost:9999/test/map";
//        String url = "http://localhost:1111/t/json";
//        String result = restTemplate.postForObject(url, json, String.class);
//        System.out.println(result);
//    }
//
//}
