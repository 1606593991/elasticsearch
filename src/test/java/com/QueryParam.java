package com;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class QueryParam {

	private QueryParamHead queryParamHead;

	private JSONObject jsonParam;
	
	public QueryParam() {
		
	}
	
	public QueryParam(QueryParamHead queryParamHead, JSONObject jsonParam) {
		super();
		this.queryParamHead = queryParamHead;
		this.jsonParam = jsonParam;
	}
	

	


	public QueryParamHead getQueryParamHead() {
		return queryParamHead;
	}

	public void setQueryParamHead(QueryParamHead queryParamHead) {
		this.queryParamHead = queryParamHead;
	}

	public JSONObject getJsonParam() {
		return jsonParam;
	}

	public void setJsonParam(JSONObject jsonParam) {
		this.jsonParam = jsonParam;
	}
	
	
	public static void main(String[] args) {
		QueryParam queryParam =new QueryParam();
		QueryParamHead queryParamHead =new QueryParamHead();
		queryParamHead.setAuthCode("123FZE");
		queryParamHead.setQueryMethod("queryBySealCode");
		queryParam.setQueryParamHead(queryParamHead);
		String jsonMessage = "{\"sealCode\":\"123456789\",\"IPAddr\":\"127.0.0.1\"}";
		JSONObject jsonParam=JSONObject.parseObject(jsonMessage);;
		queryParam.setJsonParam(jsonParam);
		String jsonstr=JSON.toJSONString(queryParam);
		System.out.println(jsonstr);
	}
	
}
