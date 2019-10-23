package com.wyb.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class StringHelper {
	/**32位UUID**/
	public static String UUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

	public static final String ipP = "(\\d+\\.\\d+\\.\\d+\\.\\d+)";
	public static String getIP(String ip) {
		Pattern p = Pattern.compile(ipP);
		Matcher m = p.matcher(ip);
		while (m.find()) {
			ip = m.group(1);
		}
		return ip;
	}
	public static String getAppAttachSavePath(String rootDir,String phoneNum,String fileType, String fileExt) {
		String fileName =phoneNum+"_"+fileType+fileExt;
		// 保存根目录
		String rootPath =rootDir+File.separator+"appAttach"+File.separator+fileName;
		
		return rootPath;
	}

	public static String LOGUUID(String areaCode, Date logDate) {
		String uuid = UUID.randomUUID().toString();
		return areaCode + "-" + String.valueOf(logDate.getTime()) + "-" + uuid.replaceAll("-", "");
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		return request.getHeader("x-requested-with") != null
				&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
	}

	public static String getAreaCodeByUnitCode(String compCode) {
		return compCode.substring(0, 6);
	}

	public static String getAreaCodeBySealCode(String sealCode) {
		return sealCode.substring(0, 6);
	}

	public static String getRandStr(int length) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid.substring(0, length).toUpperCase();
	}

	/***
	 * 获取27位的门市订单编号
	 * @param mscode
	 * @param nowDay
	 * @param currentMaxCode
	 * @return
	 */
	public static String getNextOrderId20(String mscode, String nowDay, String currentMaxCode) {
		String ss=currentMaxCode.substring(14);
		Long currentNumL = Long.parseLong(ss);
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < 4) {
			// 补0位
			while (nextNumStr.length() < 6) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return  mscode+nowDay+nextNumStr;
	}

	public static boolean isEmpty(Object str) {
		return ( null==str || "".equals(str));
	}
	
	public static boolean isSixAreaCode(Object areaCode) {
		if(!isEmpty(areaCode)){
			if(areaCode.toString().length()==6){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是国家级 如：000000
	 */
	public static boolean isCountry(String adminAreaCode) {
		return adminAreaCode.equals("000000");
	}

	/**
	 * 是省级 如：450000
	 */
	public static boolean isProvince(String adminAreaCode) {
		return !isCountry(adminAreaCode) && adminAreaCode.substring(2).equals("0000");
	}

	/**
	 * 是市级 如：450100
	 */
	public static boolean isCity(String adminAreaCode) {
		return !isProvince(adminAreaCode) && adminAreaCode.substring(4).equals("00");
	}

	/**
	 * 是县级 如：450101
	 */
	public static boolean isArea(String adminAreaCode) {
		return !adminAreaCode.substring(4, 6).equals("00");
	}

	/**
	 * 是国家级、省一级、市一级 如：000000、450000、452100
	 */
	public static String getParentAreaCode(String adminAreaCode) {
		String parentCode = "noting";
		// 国家级
		if (isCountry(adminAreaCode)) {
			parentCode = "______";
		}
		// 省级
		else if (isProvince(adminAreaCode)) {
			parentCode = adminAreaCode.substring(0, 2) + "____";
		}
		// 市级
		else {
			parentCode = adminAreaCode.substring(0, 4) + "__";
		}
		return parentCode;
	}

	/**
	 * 返回市级单位 450301 返回450300
	 */
	public static String getParentCity(String areaCode) {
		if (isArea(areaCode)) {
			return areaCode.substring(0, 4) + "00";
		} else {
			return areaCode;
		}
	}
	/**返回市级like条件**/
	public static String getAreaCodeCityLike(String areaCode) {
		return areaCode.substring(0, 4) + "__";
	}
	
	/**工商DWDM不只6位**/
	public static String getAreaCodeCityLikeAll(String areaCode) {
		return areaCode.substring(0, 4) + "%";
	}
	public static String getAreaCodeLike(String areaCode) {
		String parentCode = "noting";
		// 国家级
		if (isCountry(areaCode)) {
			parentCode = "______";
		}
		// 省级
		else if (isProvince(areaCode)) {
			parentCode = areaCode.substring(0, 2) + "____";
		}
		// 市级
		else if (isCity(areaCode)) {
			parentCode = areaCode.substring(0, 4) + "__";
		} else {
			parentCode = areaCode;
		}
		return parentCode;
	}
	
	public static String getGSJAreaCodeLike(String areaCode) {
		String parentCode = "noting";
		// 国家级
		if (isCountry(areaCode)) {
			parentCode = "%";
		}
		// 省级
		else if (isProvince(areaCode)) {
			parentCode = areaCode.substring(0, 2) + "%";
		}
		// 市级
		else if (isCity(areaCode)) {
			parentCode = areaCode.substring(0, 4) + "%";
		} else {
			parentCode = areaCode + "%";;
		}
		return parentCode;
	}

	public static String getNextAreaCode(String areaCode) {
		if (isCountry(areaCode)) {
			return "__0000";
		} else if (isProvince(areaCode)) {
			return areaCode.substring(0, 2) + "__00";
		} else if (isCity(areaCode)) {
			return areaCode.substring(0, 4) + "__";
		} else {
			return areaCode;
		}

	}

	public static String getCityAreaCode(String areaCode) {
		return areaCode.substring(0, 2) + "__00";
	}

	public static String getSambaSavePath(String sealCode) {
		// type:zip,bit,blackbmp,redbmp
		String savePath = File.separator;
		String areaCode = sealCode.substring(0, 6);

		if (isCountry(areaCode)) {
			savePath += areaCode + File.separator;
		} else if (isProvince(areaCode)) {
			savePath += areaCode.substring(0, 2) + File.separator + areaCode + File.separator;
		} else {
			savePath += areaCode.substring(0, 2) + File.separator + areaCode.substring(0, 4) + File.separator
					+ areaCode + File.separator;
		}

		// 按照序号进行传输 0-9999 10000-19999
		savePath += getSealFoler(getSealNum(sealCode)) + File.separator;
		return savePath;
	}

	public static String getSealFoler(String sealNum) {
		String folderName = "temp";
		if (null != sealNum && !"".equals(sealNum)) {
			Long sealNumL = Long.parseLong(sealNum);
			Long inFolder = sealNumL / SEAL_FOLDER_PERNUM;
			folderName = String.valueOf(inFolder * SEAL_FOLDER_PERNUM) + "_"
					+ String.valueOf(inFolder * SEAL_FOLDER_PERNUM + 9999);
		}
		return folderName;
	}

	private static Long SEAL_FOLDER_PERNUM = 10000L;

	private static String getSealNum(String sealCode) {
		if (sealCode.length() == 13) {
			return sealCode.substring(6);
		} else {
			return "";
		}
	}

	private static final String[] SEAL_SPLIT_CHAR = { "/", "*", "X", "Z", "。" };

	public static String getSealWidth(String sdsize) {
		String width = sdsize;
		for (String s : SEAL_SPLIT_CHAR) {
			if (sdsize.contains(s)) {
				if ("*".equals(s)) {
					width = sdsize.split("[*]")[0].trim();
				} else {
					width = sdsize.split(s)[0].trim();
				}
				break;
			}
		}
		return width;
	}

	public static String getSealHeight(String sdsize) {
		String height = sdsize;
		for (String s : SEAL_SPLIT_CHAR) {
			if (sdsize.contains(s)) {
				if ("*".equals(s)) {
					height = sdsize.split("[*]").length > 1 ? sdsize.split("[*]")[1].trim() : sdsize.trim();
				} else {
					height = sdsize.split(s).length > 1 ? sdsize.split(s)[1].trim() : sdsize.trim();
				}

				break;
			}
		}
		return height;
	}
	
	
	
	
	
	
	


	/**
	 * 
	 * @param areaCode
	 * @param beginNum
	 * @return
	 */
	public static String getNextSealCode(String areaCode, long beginNum) {
		String numStr = String.valueOf(beginNum);
		while (numStr.length() < 7) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	public static String getNextUnitCode(String areaCode, long beginNum) {
		String numStr = String.valueOf(beginNum);
		while (numStr.length() < 6) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	/**
	 * 返回省级查询 like 字段
	 */
	public static String getProvinceCodeLikeStr(String areaCode) {
		return areaCode.substring(0, 2) + "____";
	}
	
	/**
	 * 返回市级查询 like 字段
	 */
	public static String getCityCodeLikeStr(String areaCode) {
		return areaCode.substring(0, 4) + "__";
	}

	// 拼接印章编码
	public static String getSealCode(String areaCode, String beginCode) {
		String numStr = beginCode;
		while (numStr.length() < 7) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	// 拼接单位编码
	public static String getUnitCode(String areaCode, String beginCode) {
		String numStr = beginCode;
		while (numStr.length() < 6) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	// 生成印章编码
	public static String createNextSealCode(String areaCode, String currentMaxSealCode, String minAuunSealCode) {
		boolean needAdd = false;
		if (isEmpty(currentMaxSealCode)) {
			currentMaxSealCode = minAuunSealCode;
			needAdd = true;
		}

		String numStr = String.valueOf(Long.parseLong(currentMaxSealCode.substring(6)) + 1);
		// MINauun 为1
		if (needAdd) {
			numStr = String.valueOf(Long.parseLong(currentMaxSealCode.substring(6)));
		}
		while (numStr.length() < 7) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	// 生成单位编码
	public static String createNextUnitCode(String areaCode, String currentMaxUnitCode, String minAuunUnitCode) {
		boolean needAdd = false;
		if (isEmpty(currentMaxUnitCode)) {
			currentMaxUnitCode = minAuunUnitCode;
			needAdd = true;
		}

		String numStr = String.valueOf(Long.parseLong(currentMaxUnitCode.substring(6)) + 1);
		if (needAdd) {
			numStr = String.valueOf(Long.parseLong(currentMaxUnitCode.substring(6)));
		}
		while (numStr.length() < 6) {
			numStr = "0" + numStr;
		}
		return areaCode + numStr;
	}

	/**
	 * 使用单位 名称变更
	 */
	public static boolean CorpUnitNameChanged(String lgcoMemo) {
		return lgcoMemo.contains("单位名称");
	}
	
	/**
	 * 使用单位 社会信用代码变更
	 */
	public static boolean CorpLicnumChanged(String lgcoMemo) {
		return lgcoMemo.contains("社会信用代码");
	}

	/**
	 * 生产准刻证号码 年份 +六位数字
	 */
	public static String createNextRecordNum(String currentMaxRecordNum) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String currentYear = String.valueOf(year);
		if (isEmpty(currentMaxRecordNum)) {
			return currentYear + "000001";
		} else if (currentYear.equals(currentMaxRecordNum.substring(0, 4))) {
			String numStr = String.valueOf(Long.parseLong(currentMaxRecordNum.substring(4)) + 1);
			while (numStr.length() < 6) {
				numStr = "0" + numStr;
			}
			return currentYear + numStr;
		} else {
			return currentYear + "000001";
		}
	}

	/**
	 * 验证印章编码参数合法 4501010000001,4501010000002,4501010000003
	 */
	public static String[] verifySealCodesParam(String sealCodes) {

		// 验证是否包含特殊字符
		if (!StringHelper.verifyPattern(sealCodes)) {
			String[] sealCodeArray = sealCodes.split(",");
			for (String sealCode : sealCodeArray) {
				if (sealCode.length() < 13) {
					sealCodeArray = null;
					break;
				}
			}
			return sealCodeArray;
		}
		return null;
	}

	/**
	 * 防止SQL注入，过滤特殊字符
	 * 
	 * @param str
	 *            验证的字符串
	 * @return 包含有特殊字符 返回 true 无返回false
	 */
	public static boolean verifyPattern(String str) {
		if (!StringHelper.isEmpty(str)) {
			Pattern pattern = Pattern.compile("(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
					+ "(\\b(select|update|and|or|delete|insert|trancate"
					+ "|char|into|substr|ascii|declare|exec|count|master" + "|into|drop|execute)\\b)",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
		}
		return true;
	}
	
	/**获取审批单位保存备案专用章的路径**/
	public static String getAunitSealimgPath(String rootDir,String auunUnitcode,String fileExt) {
		// 保存根目录
		String rootPath = "aunitSeal";
		String fileName = auunUnitcode  + fileExt;
		// 保存目录
		String savePath = rootPath;

		// 创建目录
		File saveDir = new File(rootDir + File.separator + savePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		return savePath + File.separator + fileName;
	}
	
	/**获取违规处罚通知单图片路径**/
	public static String getyzzzdwcfmgPath(String rootDir,String ywlsh,String fileExt) {
		// 保存根目录
		String rootPath = "yzzzdwcf";
		String fileName = ywlsh  + fileExt;
		// 保存目录
		String savePath = rootPath;

		// 创建目录
		File saveDir = new File(rootDir + File.separator + savePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		return savePath + File.separator + fileName;
	}
	/** 计算打印编号 **/
	public static String getNextPrintNum(String currentNum) {
		String thisYear = DateUtil.getNowDate().substring(0, 4);

		if (isEmpty(currentNum) || currentNum.length() < 10) {
			return thisYear + "0000001";
		}
		//
		else if (!currentNum.substring(0, 4).equals(thisYear)) {
			return thisYear + "0000001";
		} else {
			Long currentNumL = Long.parseLong(currentNum.substring(4));

			Long nextNumL = currentNumL + 1;
			String nextNumStr = String.valueOf(nextNumL);
			if (nextNumStr.length() < 7) {
				// 补0位
				while (nextNumStr.length() < 7) {
					nextNumStr = "0" + nextNumStr;
				}
			}
			return thisYear + nextNumStr;
		}
	}
	/** 计算打印编号 **/
	public static String getNextPrintNum(String areaCode,String currentNum) {
		String thisYear = DateUtil.getNowDate().substring(0, 4);

		if (isEmpty(currentNum) || currentNum.length() < 16) {
			return areaCode + thisYear + "000001";
		}
		//
		else if (!currentNum.substring(6, 10).equals(thisYear)) {
			return areaCode + thisYear + "000001";
		} else {
			Long currentNumL = Long.parseLong(currentNum.substring(10));
			Long nextNumL = currentNumL + 1;
			String nextNumStr = String.valueOf(nextNumL);
			if (nextNumStr.length() < 6) {
				// 补0位
				while (nextNumStr.length() < 6) {
					nextNumStr = "0" + nextNumStr;
				}
			}
			
			return areaCode + thisYear + nextNumStr;
		}
	}

	/**
	 * 权限是否同级别 (判断超级管理员、普通管理员)
	 * 
	 * @param currentRoles
	 * @param deletedRoles
	 * @return
	 */
	public static boolean isSameLevel(String currentRoles, String deletedRoles) {
		// 超级管理员不能删除超级管理员
		if (currentRoles.contains("ROLE_SUPER") && deletedRoles.contains("ROLE_SUPER")) {
			return true;
		}

		// 管理员不能删除管理员
		if (!currentRoles.contains("ROLE_SUPER") && currentRoles.contains("ROLE_ADMIN") && deletedRoles.contains("ROLE_ADMIN")) {
			return true;
		}

		return false;
	}

	/**
	 * 权限是否同级别 (只判断普通管理员)
	 * 
	 * @param currentRoles
	 * @param deletedRoles
	 * @return
	 */
	public static boolean isSameRoleAdmin(String currentRoles, String deletedRoles) {
		// 管理员不能删除管理员
		if (!currentRoles.contains("ROLE_SUPER") && currentRoles.contains("ROLE_ADMIN")
				&& deletedRoles.contains("ROLE_ADMIN")) {
			return true;
		}

		return false;
	}

	/**
	 * 只判断是否审批员
	 * 
	 * @param currentRoles
	 * @param deletedRoles
	 * @return
	 */
	public static boolean isRoleAudit(String roles) {
		if (roles.contains("ROLE_AUDIT")) {
			return true;
		}
		return false;
	}

	

	

	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static List<String> getAuthAreaCode(String areaCode, String authAreacode) {
		List<String> arecodes = new ArrayList<String>();
		arecodes.add(areaCode);
		if (!isEmpty(authAreacode)) {
			for (String _areaCode : authAreacode.split(",")) {
				if (!isEmpty(_areaCode) && _areaCode.length() == 6) {
					arecodes.add(_areaCode);
				}
			}
		}
		return arecodes;
	}

	public static String getDisplayTime(String value) {
		if (!isEmpty(value) && value.length() > 10) {
			return value.substring(0, 10);
		} else {
			return "";
		}
	}

	/**
	 * 时间格式转换 20150924 2015-09-24
	 */
	public static String getYYYYMMDDTime(String value) {
		if (!isEmpty(value) && value.length() == 8) {
			return value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6, 8);
		} else {
			return value;
		}
	}
	/**
	 * 印章备案证 刻章时间 
	 * 制章时间为空则取审批时间
	 */
	public static String getKZtime(String underMakeTime,String auditTime) {
		if(!isEmpty(underMakeTime)){
			return getYYYYMMDDTime(underMakeTime);
		}else{
			return getYYYYMMDDTime(auditTime);
		}
	}

	public static String getObjString(Object str) {
		if (isEmpty(str)) {
			return "";
		} else {
			return str.toString();
		}
	}
	
	public static String getObjString(Object str,String defaultNum) {
		if (isEmpty(str)) {
			return defaultNum;
		} else {
			return str.toString();
		}
	}

	

	/** 参数为null或者空返回true **/
	public static boolean inFilterAreaCode(String filterAreacode, String areacode) {
		if (!isEmpty(filterAreacode) && !isEmpty(areacode)) {
			String areacodes[] = filterAreacode.split(",");
			for (String _areacode : areacodes) {
				// 省
				if (_areacode.length() == 2) {
					if (_areacode.equals(areacode.substring(0, 2))) {
						return true;
					}
				} else if (_areacode.length() == 4) {
					if (_areacode.equals(areacode.substring(0, 4))) {
						return true;
					}
				} else if (_areacode.length() == 6) {
					if (_areacode.equals(areacode)) {
						return true;
					}
				}
			}
			return false;
		} else {
			return true;
		}
	}
	public static String getCnByType(String wsosType) {
		if("1".equals(wsosType)){
			return "实物印章";
		}
		if("2".equals(wsosType)){
			return "电子印章";
		}
		if("3".equals(wsosType)){
			return "物电一体";
		}
		return "";
	}
	public static String getWscoOrderstatus(String wscoOrderstatus) {
		if("2".equals(wscoOrderstatus)){
			return "待承接";
		}
		if("3".equals(wscoOrderstatus)){
			return "制作中";
		}
		if("4".equals(wscoOrderstatus)){
			return "待领章";
		}
		if("5".equals(wscoOrderstatus)){
			return "已领章";
		}
		return "";
	}
	public static String getCnByTypeCode(String sealStypecode) {
		if (sealStypecode.equals("01")) {
			return "单位专用章";
		}
		if (sealStypecode.equals("02")) {
			return "财务专用章";
		}
		if (sealStypecode.equals("03")) {
			return "发票专用章";
		}
		if (sealStypecode.equals("04")) {
			return "合同专用章";
		}
		if (sealStypecode.equals("05")) {
			return "法人名章";
		}
		if (sealStypecode.equals("99")) {
			return "其他";
		}
		return sealStypecode;
	}

	public static String getCnByMatelCode(String sealMatelcode) {
		if (sealMatelcode.equals("01")) {
			return "有机玻璃";
		}
		if (sealMatelcode.equals("02")) {
			return "铜";
		}
		if (sealMatelcode.equals("03")) {
			return "钢";
		}
		if (sealMatelcode.equals("04")) {
			return "塑橡";
		}
		if (sealMatelcode.equals("05")) {
			return "牛角";
		}
		if (sealMatelcode.equals("06")) {
			return "光敏";
		}
		if (sealMatelcode.equals("07")) {
			return "回墨";
		}
		if (sealMatelcode.equals("99")) {
			return "其他";
		}
		return sealMatelcode;
	}

	public static String getCnByShapeCode(String sealShapecode) {
		if (sealShapecode.equals("1")) {
			return "圆形";
		}
		if (sealShapecode.equals("2")) {
			return "椭圆形";
		}
		if (sealShapecode.equals("3")) {
			return "正方形";
		}
		if (sealShapecode.equals("4")) {
			return "长方形";
		}
		if (sealShapecode.equals("5")) {
			return "上三角形";
		}
		if (sealShapecode.equals("6")) {
			return "下三角形";
		}
		return sealShapecode;
	}

	public static String getCnStatusByCode(String sealStatuscode) {
		if (sealStatuscode.equals("1")) {
			return "已承接";
		}
		if (sealStatuscode.equals("2")) {
			return "已下载";
		}
		if (sealStatuscode.equals("3")) {
			return "已制作";
		}
		if (sealStatuscode.equals("4")) {
			return "已备案";
		}
		if (sealStatuscode.equals("5")) {
			return "已报废";
		}
		if (sealStatuscode.equals("6")) {
			return "已注销";
		}
		if (sealStatuscode.equals("7")) {
			return "已挂失";
		}
		return sealStatuscode;
	}

	public static String getCnComtypeByCode(String corpComtype) {
		if (corpComtype.equals("01")) {
			return "党政机关";
		} else if (corpComtype.equals("02")) {
			return "企业单位";
		} else if (corpComtype.equals("03")) {
			return "事业单位";
		} else if (corpComtype.equals("04")) {
			return "社会团体";
		} else if (corpComtype.equals("05")) {
			return "民办非企业单位";
		} else {
			return "其他";
		}
	}
	
	public static String getDefaultValue(Object obj,String defaultValue) {
		if(isEmpty(obj)){
			return defaultValue;
		}else{
			return obj.toString();
		}
	}
	
	public static String getDefaultValue(Object obj) {
		if(isEmpty(obj)){
			return "";
		}else{
			return obj.toString();
		}
	}

	public static String getDateRandomFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date()) + "_" + new Random().nextInt(1000);
	}
	
	
	
	
	
	/**
	 * 去掉末位的符号
	 * @param inputStr
	 * @param split
	 * @return
	 */
	public static String cutLastChar(String inputStr) {
		if(isEmpty(inputStr)){
			return inputStr;
		}else{
			return inputStr.substring(0,inputStr.length()-1);
		}
	}
	
	
	/**
	 * 获取地区编码
	 */
	public static String getFullAreacode(Object areaCode) {
		if(isEmpty(areaCode)){
			return "000000";
		}else if(String.valueOf(areaCode).length()==2){
			return String.valueOf(areaCode)+"0000";
		}else if(String.valueOf(areaCode).length()==4){
			return String.valueOf(areaCode)+"00";
		}else{
			return String.valueOf(areaCode);
		}
	}

	/**实物印章印模是否存储
	 * -1 不存在
	 * 0 存在未混淆目录
	 * 1 存在混淆目录**/
	public static boolean isExitSealImg(int savePath) {
		return savePath >-1;
	}

	 /**是否在权限范围内**/
	public static boolean isChildArea(String parentAreaCode, String childAreaCode) {
		if(childAreaCode.equalsIgnoreCase(parentAreaCode)){
			return true;
		}
		//县级制作单位
		if(isArea(parentAreaCode)){
			return childAreaCode.equalsIgnoreCase(parentAreaCode);
		}		
		else if(isCity(parentAreaCode)){
			return childAreaCode.substring(0, 4).equalsIgnoreCase(parentAreaCode.substring(0, 4));
		}else if(isProvince(parentAreaCode)){
			return childAreaCode.substring(0, 2).equalsIgnoreCase(parentAreaCode.substring(0, 2));
		}else{
			return true;
		}
	}

	/**获取办件号**/
	public static String getNextApplyCode(String thisYear, String currentOrderId) {
		Long currentNumL = Long.parseLong(currentOrderId.substring(4));
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < 7) {
			// 补0位
			while (nextNumStr.length() < 7) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return thisYear + nextNumStr;
	}
	/**计算下一个 编号**/
	public static String getNextBH(String thisYear, String currentOrderId) {
		Long currentNumL = Long.parseLong(currentOrderId.substring(4));
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < 6) {
			// 补0位
			while (nextNumStr.length() < 6) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return thisYear + nextNumStr;
	}
	
	/**计算下一个 编号**/
	public static String getNextBH7(String thisYear, String currentOrderId) {
		Long currentNumL = Long.parseLong(currentOrderId.substring(4));
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < 7) {
			// 补0位
			while (nextNumStr.length() < 7) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return thisYear + nextNumStr;
	}
	/**计算下一个 编号**/
	public static String getNextBH11(String thisDay, String currentOrderId) {
		Long currentNumL = Long.parseLong(currentOrderId.substring(4));
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < 5) {
			// 补0位
			while (nextNumStr.length() < 5) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return thisDay + nextNumStr;
	}
	
	public static String getNextBHByNum(String currentOrderId,int num) {
		Long currentNumL = Long.parseLong(currentOrderId);
		Long nextNumL = currentNumL + 1;
		String nextNumStr = String.valueOf(nextNumL);
		if (nextNumStr.length() < num) {
			// 补0位
			while (nextNumStr.length() < num) {
				nextNumStr = "0" + nextNumStr;
			}
		}
		return nextNumStr;
	}
	
	
	/**
	 * @param len 密码长度   数字随机密码
	 * */
	public static String getRandomRipher(int len) {
		String code="";
	    Random rand=new Random();
	    for(int i=0;i<len;i++){
	    	code+=rand.nextInt(10);
	     }
	    return code;
	}
	
	public static void main(String[] args) {

		//System.out.println(getYYYYMMDDTime("20150932"));
		//System.out.println(getYYYYMMDDTime("2015924"));
	}
	/**是否为单位专用章**/
	public static boolean isDWZYZ(String wsosStypecode) {
		return "01".equals(wsosStypecode);
	}
	
}
