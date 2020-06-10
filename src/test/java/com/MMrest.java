package com;//package cn.gov.gd.scheduler.task;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import cn.gov.gd.dao.ProduceAccountMapper;
//import cn.gov.gd.dao.SystemAccountMapper;
//import cn.gov.gd.model.ProduceAccount;
//import cn.gov.gd.model.SystemAccount;
//import cn.gov.gd.util.EncryptUtil;
//
//public class MMrest {
// private Logger logger = Logger.getLogger(MMrest.class);
//	public void run() throws Exception {
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("limitnum", 10000);
////		List<SystemAccount> sel = systemAccountMapper.selectByMap(map);
////		for (int i = 0; i < sel.size(); i++) {
////			SystemAccount ss = sel.get(i);
////			String pwd = sel.get(i).getSysaPassword();
//////			String jm=EncryptUtil.decrypt(pwd);
////			System.out.println("s"+pwd+"111:"+EncryptUtil.decrypt(pwd));
//////			System.out.println(EncryptUtil2.encryptPwd(jm));
////			ss.setSysaPassword(EncryptUtil.encryptPwdByBase64(pwd));
////			System.out.println(EncryptUtil.encryptPwdByBase64("123456"));
////			System.out.println(EncryptUtil.encryptPwdByBase64(pwd));
////			systemAccountMapper.updateByPrimaryKey(ss);
////		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("limitnum", 10000);
//		List<ProduceAccount> sel = produceAccountMapper.selectByMap(map);
//		for (int i = 0; i < sel.size(); i++) {
//			ProduceAccount ss = sel.get(i);
//			String pwd = sel.get(i).getProdPwd();
//			System.out.println(EncryptUtil.encryptPwdByBase64("123456"));
//			ss.setProdPwd(EncryptUtil.encryptPwdByBase64(pwd));
//			produceAccountMapper.updateByPrimaryKeySelective(ss);
//		}
//	}
//	
//	@Autowired
//	private SystemAccountMapper systemAccountMapper;
//	
//	@Autowired
//	private ProduceAccountMapper produceAccountMapper;
//}
