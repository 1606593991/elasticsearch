package com;

import java.nio.charset.Charset;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {
	/**
     * 创建指定字符集的RestTemplate
     *
     * @param charset
     * @return
     */
    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName(charset)));
        return restTemplate;
    }

}
