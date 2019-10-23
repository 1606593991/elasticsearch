package com.wyb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static String DATE_FORMAT_FULL 			= "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static String DATE_FORMAT_NORMAL 		= "yyyy-MM-dd HH:mm:ss";
	
	public static String DATE_FORMAT_QUERY			= "yyyy-MM-dd HH:mm";
	
	public static String DATE_FORMAT_DATE 			= "yyyy年MM月dd日";
	
	public static String DATE_FORMAT 				= "yyyyMMdd";
	
	public static String DATE_FORMAT_YYYY_MM_DD 	= "yyyy-MM-dd";
	
	public static String DATE_FORMAT_YYYY_MM_DD_HH 	= "yyyy-MM-dd HH";
	
	public static String DATE_FORMAT_YYYYMMDDHHmmss = "yyyyMMddHHmmss";
	
	public static String DATE_FORMAT_YYYYMMDDHHmmssSSS = "yyyyMMddHHmmssSSS";
	
	public static String DATE_FORMAT_NORMAL_CN 		= "yyyy年MM月dd日HH:mm:ss";
	
	public static final String QUERY_PARAM_DATE_BEGIN = "000000";
	
	public static final String QUERY_PARAM_DATE_END = "235959";
	
	public static final String QUERY_PARAM_DATE_BEGIN2 = " 00:00:00";
	
	public static final String QUERY_PARAM_DATE_END2 = " 23:59:59";

	public static Calendar formatRDate(String strDate) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Calendar cal = Calendar.getInstance();
		try {
			date = sdf2.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * 返回带毫秒的时间
	 */
	public static String dateToStr(java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FULL);
		return format.format(date);
	}
	/**
	 * 数字格式的时间
	 */
	public static String dateToStrnum(java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHmmss);
		return format.format(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String date2Str(java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_QUERY);
		return format.format(date);
	}

	public static String dateToStrNormal(java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_NORMAL);
		return format.format(date);
	}
	
	public static String nowDate8Str() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(new Date());
	}
	
	public static String nowDateNormal() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_NORMAL);
		return format.format(new Date());
	}
	
	public static String nowDate8Str(String defaultTime) {
		if(!StringHelper.isEmpty(defaultTime)&&defaultTime.length()==8){
			return defaultTime;
		}else{
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
			return format.format(new Date());
		}
		
	}
	
	public static String nowDate8Str(Integer addDay) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(getBeforDay(addDay));
	}

	public static Date strToDate(String strDate) {
		SimpleDateFormat dtFormat = null;
		try {
			if (strDate.length() == DATE_FORMAT_QUERY.length()) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_QUERY);
			} else if (strDate.length() == DATE_FORMAT_YYYY_MM_DD.length()) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
			} else if (strDate.length() == DATE_FORMAT_NORMAL.length()) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_NORMAL);
			} else if (strDate.length() == DATE_FORMAT_YYYYMMDDHHmmssSSS.length()) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHmmssSSS);
			} else if (strDate.length() == DATE_FORMAT_YYYYMMDDHHmmss.length()) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHmmss);
			}

			return dtFormat.parse(strDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Date stirngToDate(String strDdate, String format) {
		SimpleDateFormat dtFormat = null;
		
		try {
			if (format.equals(DATE_FORMAT_FULL)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_FULL);
			} else if (format.equals(DATE_FORMAT_NORMAL)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_NORMAL);
			}  else if (format.equals(DATE_FORMAT_QUERY)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_QUERY);
			} else if (format.equals(DATE_FORMAT_DATE)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_DATE);
			}  else if (format.equals(DATE_FORMAT)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT);
			} else if (format.equals(DATE_FORMAT_YYYY_MM_DD)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
			}

			return dtFormat.parse(strDdate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getNowTime2() {
		
		long currentTimeMillis = System.currentTimeMillis();//生成时间戳
		long second = currentTimeMillis / 1000L;
		String seconds = String.valueOf(second).substring(0, 10);
		return seconds;
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//    	return format.format(Calendar.getInstance().getTime());
	}
	
	public static Date stringToDate(String strDdate, String format) {
		SimpleDateFormat dtFormat = null;
		
		try {
			if (format.equals(DATE_FORMAT_FULL)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_FULL);
			} else if (format.equals(DATE_FORMAT_NORMAL)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_NORMAL);
			}  else if (format.equals(DATE_FORMAT_QUERY)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_QUERY);
			} else if (format.equals(DATE_FORMAT_DATE)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_DATE);
			}  else if (format.equals(DATE_FORMAT)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT);
			} else if (format.equals(DATE_FORMAT_YYYY_MM_DD)) {
				dtFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
			}
			

			return dtFormat.parse(strDdate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时间描述
	 */
	public static String getDateSpoken() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour < 8) {
			return "早上";
		} else if (hour >= 8 && hour < 11) {
			return "上午";
		} else if (hour >= 11 && hour < 13) {
			return "中午";
		} else if (hour >= 13 && hour < 18) {
			return "下午";
		} else {
			return "晚上";
		}
	}

	public static String getNowDate() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DATE);
		return format.format(new Date());
	}
	
	
	public static String getNowDate(String dateFormate) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormate);
		return format.format(new Date());
	}
	
	public static String getStringDate(Date date,String dateFormate) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormate);
		return format.format(date);
	}

	public static String getNowDay() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return format.format(new Date());
	}

	/**
	 * 获取明天 
	 */
	public static String getTomorrowDay() {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return format.format(cd.getTime());
	}
	
	/**
	 * 获取明天
	 */
	public static Date getTomorrowDate() {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return cd.getTime();
	}
	
	/**
	 * 获取昨天
	 */
	public static Date getYesterday() {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, -1);
		return cd.getTime();
	}
	
	
	/**
	 * 几小时前
	 */
	public static Date getBeforeHour(int hour) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.HOUR, hour);
		return cd.getTime();
	}
	
	public static String getBeforeHourCn(int hour) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.HOUR, hour);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FULL);
		return format.format(cd.getTime());
	}
	
	public static String getBeforeHourCn(int hour,String dateFormate) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.HOUR, hour);
		SimpleDateFormat format = new SimpleDateFormat(dateFormate);
		return format.format(cd.getTime());
	}
	
	public static String getBeforeYearCn(int year) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.YEAR, year);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FULL);
		return format.format(cd.getTime());
	}
	
	
	
	
	/**
	 * 获取几天前
	 * 负数：前几天
	 * 正数：后几天
	 */
	public static Date getBeforDay(Integer day) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, day);
		return cd.getTime();
	}
	
	/**
	 * 获取几个月
	 * 负数：前几月
	 * 正数：后几月
	 */
	public static Date getBeforMonth(Integer month) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.MONTH, month);
		return cd.getTime();
	}
	

	
	
	
	/**
	 * 获取当天凌晨时间 起点
	 */
	public static Date getNowDayZero() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    //SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_NORMAL);
	    return  cal.getTime();
	   // return format.format(cal.getTime());
	}
	
	/**
	 * 获取当天夜晚时间 终点
	 */
	public static Date getNowDay59() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
	    cal.set(Calendar.HOUR_OF_DAY, 23);
	    cal.set(Calendar.MINUTE, 59);
	    cal.set(Calendar.SECOND, 59);
	    cal.set(Calendar.MILLISECOND, 0);
	    //SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_NORMAL);
	    return  cal.getTime();
	   // return format.format(cal.getTime());
	}
	
	/**
	 * 获取昨天
	 */
	public static String getYesterdayStr() {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, -1);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return format.format(cd.getTime());
	}
	
	
	/**
	 * 获取几分钟前
	 * 负数：前几天
	 * 正数：后几天
	 */
	public static Date getBeforeMin(Integer min) {
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.MINUTE, min);
		return cd.getTime();
	}
	
	/**
	 * 获取几分钟前
	 */
	public static Date getBeforeMin(int min,Date date) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.MINUTE, min);
		return cd.getTime();
	}
	
	/**
	 * 获取几天前
	 * 负数：前几天
	 * 正数：后几天
	 */
	public static Date getBeforeDay(int day,Date date) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.DATE, day);
		return cd.getTime();
	}
	
	/**
	 * 获得本年第一天的日期
	 */
	public static String getCurrentYearFirstDate() {
		int yearPlus = getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		// DateFormat df = DateFormat.getDateInstance();
		String preYearDay = format.format(yearDay);
		return preYearDay;
	}

	private static int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	public static Date getExpireDate(int month) {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.MONTH, month);
		return cd.getTime();
	}

	public static String getCNDate(Date lgesSigndate) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_NORMAL_CN);
		return format.format(lgesSigndate);
	}
	
	/**用于发送签章短信**/
	public static String getCNSMS(String lgesSigntime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss.SSS");
		return format.format(stringToDate(lgesSigntime,"yyyy-MM-dd HH:mm:ss.SSS"));
	}
	
	public static String strDate2NowDay(String strDate) {
		Date date = strToDate(strDate);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return format.format(date);
	}
	
	public static String strDate2NowDay(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return format.format(date);
	}
	
	// 用来全局控制 上一周，本周，下一周的周数变化
    private static int weeks = 0;
   
    // 获得当前日期与本周一相差的天数
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    // 获得上周星期一的日期
    public static String getPreviousMonday() {
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        String preMonday = format.format(monday);
        return preMonday;
    }

    // 获得当前周星期一的日期
    public static String getCurrentMonday() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        String preMonday = format.format(monday);
        return preMonday;
    }

    // 获得下周星期一的日期
    public static String getNextMonday() {
        weeks++;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        String preMonday = format.format(monday);
        return preMonday;
    }

    // 获得当周的周日的日期
    public static String getSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        String preMonday = format.format(monday);
        return preMonday;
    } 
    /**
     * 得到某年某月的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month-1);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    /** 得到当年1月的第一天    */
    public static String getFirstDayOfMonth() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	    cal.set(Calendar.MONTH, 1-1);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    /** 得到当年1月的第一天    */
    public static String getFirstDayOfYear() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	    cal.set(Calendar.MONTH, 1-1);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    /** 得到当年1月的第一天    */
    public static Date getFirstDateOfYear() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	    cal.set(Calendar.MONTH, 1-1);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
	    return cal.getTime();
    }
    
   
    
    /**
     * 得到当年12月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfYear() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	    cal.set(Calendar.MONTH, 12-1);
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, value);
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
     
    /**
     * 得到某年某月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month-1);
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, value);
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    
    
    /**
     * 获取当前月份
     * 
     * @return
     */
    public static int getNowMonth() {
	    Calendar cal = Calendar.getInstance();
	    int value = cal.get(Calendar.MONTH)+1;
	    return value;
    }
    
    
    
    /**
     * 获取前某个月的第一天
     * 
     * @return
     */
    public static String getPreMonthFirstDay(int pre) {
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH, -pre+1);
	    return new SimpleDateFormat("yyyy-MM-01").format(cal.getTime());
    }
    
    
    
    /**getNow
     * 得到某年某月的前某个月的月数
     * @param pre 前几个月
     * @return
     */
    public static int getLastDayOfMonth(int pre) {
    	Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -pre);
	    // 因为是0~11月  所以 加1 好是 1~12月
	    return (c.get(Calendar.MONTH)+1);
    }
    /**
     * 得到当年12月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	    cal.set(Calendar.MONTH, 12-1);
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, value);
	    return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    /**
     * 得到某年某月的前某个月的月数
     * @param pre 前4个月
     * @return
     */
    public static String getPreMonth() {
    	Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -4);
	    return new SimpleDateFormat("yyyy-MM-01").format(c.getTime());
    }
    
    /**
     * 获取当前月的第一天
     * @param pre 当前月1号  yyyy-MM-01
     * @return
     */
    public static String getCurrentMonth() {
    	Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -0);
	    return new SimpleDateFormat("yyyy-MM-01").format(c.getTime());
    }
    
    /** 获取当前月的第一天    */
    public static Date getFirstDateOfCurrentMonth() {
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH, 0);
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
    }
    
    /**
     * 获取当前月的最后一天
     * @param pre 当前月1号  yyyy-MM-01
     * @return
     */
    public static String getCurrentMonthLastDay() {
    	Calendar cale = Calendar.getInstance();   
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为1号,当前日期既为本月第一天 
	    return new SimpleDateFormat("yyyy-MM-dd").format(cale.getTime());
    }
    
	/**
	 * 判断是否是周末
	 * @return
	 */
    public static boolean isWeekend(){
    	Calendar cal = Calendar.getInstance();
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;
		if(week==0){// week ==6 ||  0代表周日，6代表周六
			return true;
		}
		return false;
	}
    
    /**
     * 获取今天  N年前/后的时间
     * @param years
     * @return
     */
    public static Date todayAfterYear(int years){
    	Calendar calendar = Calendar.getInstance();
    	
    	Date date = new Date(System.currentTimeMillis());
    	
    	calendar.setTime(date);
    	calendar.add(Calendar.YEAR, years);
    	
    	return date = calendar.getTime();
    }
    
    /**
     * 获取某天  N年前/后的时间
     * @param years
     * @return
     */
    public static Date thisDayAfterYear(int years, Date date){
    	Calendar calendar = Calendar.getInstance();
    	
    	calendar.setTime(date);
    	calendar.add(Calendar.YEAR, years);
    	
    	return date = calendar.getTime();
    }

    /***
     * 获取当前时间戳 
     */
    public static String getNowTime(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	return format.format(Calendar.getInstance().getTime());
    }
    

    /***
     * 获取当前时间戳 
     */
    public static String getNowYear(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy");
    	return format.format(Calendar.getInstance().getTime());
    }
   
    
    
    
    public static void main(String[] args) throws InterruptedException {
    	//System.out.println(getFirstDayOfMonth());
    	//System.out.println(getLastDayOfMonth());
    	//System.out.println(dateToStrNormal(getNowDayZero()));
    	//System.out.println(dateToStrNormal(getNowDay59()));
    	
    	
    	System.out.println(getYesterday());
    	/*
    	System.out.println(getCurrentMonthLastDay());
    	System.out.println(getNowDate(DATE_FORMAT_YYYYMMDDHHmmssSSS));
    	System.out.println(DATE_FORMAT_FULL.length());
    	System.out.println(getCNSMS("2015-08-21 15:22:58.334"));
    	//20161008 //20161001
    	System.out.println(DateUtil.nowDate8Str(-7));
    	System.out.println(DateUtil.nowDate8Str(0));
    	*/
    	System.out.println("Gxxzwd201501glxt20171128gxnnjpl1".length());
	}
    
    
}
