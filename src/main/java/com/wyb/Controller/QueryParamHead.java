package com.wyb.Controller;



public class QueryParamHead {

	/**
	 * 接口版本
	 */
	private String version;
	
	/**
	 * 授權碼
	 */
	private String authCode;
	
	/**
	 * 查詢方法
	 */
	private String queryMethod;
	
	/**
	 * 事物ID
	 */
	private String tuid;
	
	/**
	 * 服务器响应开始时间
	 */
	private String serverRequestTime;

	/**
	 * 服务器响应结束时间
	 */
	private String serverResponseTime;
	
	
	
	public String getServerRequestTime() {
		return serverRequestTime;
	}

	public void setServerRequestTime(String serverRequestTime) {
		this.serverRequestTime = serverRequestTime;
	}

	public String getServerResponseTime() {
		return serverResponseTime;
	}

	public void setServerResponseTime(String serverResponseTime) {
		this.serverResponseTime = serverResponseTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getQueryMethod() {
		return queryMethod;
	}

	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}

	public String getTuid() {
		return tuid;
	}

	public void setTuid(String tuid) {
		this.tuid = tuid;
	}

}
