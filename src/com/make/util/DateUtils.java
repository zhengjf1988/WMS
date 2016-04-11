package com.make.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/***
 * 日期工具类
 * 
 * @author Administrator
 */
public class DateUtils {

	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";

	public static String[] MONTH = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

	/**
	 * 私有化构造函数
	 */
	private DateUtils() {
	}

	/**
	 * 日期加N天
	 * 
	 * @param dayAmount
	 * @param date
	 * @param pattern
	 * @return dateString
	 */
	public static final String addDay(int dayAmount, Date date, String... pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dayAmount);
		if (pattern == null || pattern.length == 0)
			return date2String(calendar.getTime());
		return date2String(calendar.getTime(), pattern[0]);
	}

	/**
	 * 日期转字符串("yyyy-MM-dd")
	 * 
	 * @param date
	 * @return dateString
	 */
	public static String date2String(Date date) {
		return date2String(date, PATTERN_DATE);
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return dateString
	 */
	public static String date2String(Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串转日期("yyyy-MM-dd")
	 * 
	 * @param strDate
	 * @return a date
	 */
	public static Date string2Date(String strDate) {
		return string2Date(strDate, null);
	}

	/**
	 * 字符串转日期
	 * 
	 * @param strDate
	 * @param pattern
	 * @return a date
	 */
	public static Date string2Date(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateUtils.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	/**
	 * 字符串转时间("yyyy-MM-dd HH:mm:ss ")
	 * 
	 * @param strDate
	 * @return a date
	 */
	public static Date string2Time(String strDate) {
		return string2Time(strDate, null);
	}

	/**
	 * 字符串转时间
	 * 
	 * @param strDate
	 * @param pattern
	 * @return a date
	 */
	public static Date string2Time(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateUtils.PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	/**
	 * 上一月
	 * 
	 * @param strDate
	 * @param pattern
	 * @return dateString
	 */
	public static String oldMonth(String strDate, String... pattern) {
		// 2014-8-15修改
		String format = "yyyy-MM-dd";
		if (pattern != null && pattern.length > 0) {
			format = pattern[0];
		}
		Date date = string2Date(strDate, format);// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format);// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.MONTH, -1);// 月份减一
		return sdf.format(calendar.getTime());
	}

	/**
	 * 上一月
	 * 
	 * @param strDate
	 * @return dateString
	 */
	public static String oldMonth2(String strDate) {
		Date date = string2Date(strDate, "yyyy-MM");// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.MONTH, -1);// 月份减一
		return sdf.format(calendar.getTime());
	}

	/**
	 * 昨天
	 * 
	 * @param strDate
	 * @return dateString
	 */
	public static String Yesterday(String strDate) {
		Date date = string2Date(strDate, "yyyy-MM-dd");// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.DATE, -1);// 天份减一
		return sdf.format(calendar.getTime());
	}

	/**
	 * 去年本月
	 * 
	 * @param strDate
	 * @return dateString
	 */
	public static String oldYear(String strDate) {
		Date date = string2Date(strDate, "yyyy-MM");// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.YEAR, -1);// 年份减一
		return sdf.format(calendar.getTime());
	}

	/**
	 * 去年今天
	 * 
	 * @param strDate
	 * @return dateString
	 */
	public static String oldDay(String strDate) {
		Date date = string2Date(strDate, "yyyy-MM-dd");// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.YEAR, -1);// 年份减一
		return sdf.format(calendar.getTime());
	}

	/**
	 * 去年
	 * 
	 * @param year
	 * @return dateString
	 */
	public static String lastYear(String year) {
		Date date = string2Date(year, "yyyy");
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.YEAR, -1);// 年份减一
		return date2String(calendar.getTime(), "yyyy");
	}

	/**
	 * 日期相减 自动提示粒度
	 * 
	 * @param startTime
	 * @param endTime
	 * @param format
	 *            ,格式化
	 * @return dateString
	 */
	public static String calculate(String startTime, String endTime, String radio) {
		String sf = "yyyy-MM-dd HH:mm";
		if (radio.equals("days")) {
			sf = "yyyy-MM-dd";
		} else if (radio.equals("mons")) {
			sf = "yyyy-MM";
		} else if (radio.equals("years")) {
			sf = "yyyy";
		}
		String temp = "";
		Date startDate = string2Date(startTime, sf);
		Date endDate = string2Date(endTime, sf);
		if (startDate.getTime() < endDate.getTime()) {
			long l = endDate.getTime() - startDate.getTime();
			long i = l / (1000 * 60 * 60 * 24);// 这是他们相差的天数。
			if (i < 10) {// 小于十天调用
				temp = "hours";
			} else if (i >= 10 && i < 180) {
				temp = "days";
			} else if (i >= 180 && !radio.equals("years")) {
				temp = "mons";
			} else {
				temp = "years";
			}

		} else if (startDate.getTime() == endDate.getTime()) {
			temp = radio;
		}
		System.out.println("=====" + temp);
		return temp;
	}

	/**
	 * 日期相减 非自动提示粒度
	 * 
	 * @param startTime
	 * @param endTime
	 * @param format
	 *            ,格式化
	 * @return dateString
	 */
	public static String nonAutoCalculate(String startTime, String endTime, String radio) {
		String sf = "yyyy-MM-dd HH:mm";
		if (radio.equals("days")) {
			sf = "yyyy-MM-dd";
		} else if (radio.equals("mons")) {
			sf = "yyyy-MM";
		} else if (radio.equals("years")) {
			sf = "yyyy";
		}
		String temp = "";
		Date startDate = string2Date(startTime, sf);
		Date endDate = string2Date(endTime, sf);
		long i = 0L;
		if (startDate.getTime() < endDate.getTime()) {
			long l = endDate.getTime() - startDate.getTime();
			i = l / (1000 * 60 * 60 * 24);// 这是他们相差的天数。
			if (i < 10 && !radio.equals("days")) {// 小于十天调用
				temp = "hours";
			} else if (i < 10 && radio.equals("days")) {// 小于十天调用
				temp = "days";
			} else if (i >= 10 && i < 180 && radio.equals("mons")) {
				temp = "mons";
			} else if (i >= 10 && i < 180 && !radio.equals("mons")) {
				temp = "days";
			} else if (i >= 180 && !radio.equals("years")) {
				temp = "mons";
			} else {
				temp = "years";
			}

		} else if (startDate.getTime() == endDate.getTime()) {
			temp = radio;
		}
		return temp;
	}

	// /**
	// * 获得某月最后一天的日期
	// *
	// * <pre>
	// * 传入格式：yyyy-mm
	// * 返回格式：yyyy-mm-dd
	// * </pre>
	// *
	// * @param date
	// * @return dateString
	// */
	// public static String getMaxDayOfMonth(String date) {
	//
	// Calendar c = Calendar.getInstance();
	// c.set(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date
	// .split("-")[1]), 1);
	// c.add(Calendar.DAY_OF_YEAR, -1);
	// return date + "-" + c.get(Calendar.DAY_OF_MONTH);
	// }

	/**
	 * 获得月的第一天
	 * 
	 * @param date
	 * @return a date
	 * */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 获得月的最后一天
	 * 
	 * @param date
	 * @return a date
	 * */
	public static Date getEndDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 判断日期是否在月份内
	 * 
	 * @param day
	 * @param monthDay
	 * */
	public static boolean isDayInMonth(Date day, Date monthDay) {
		if (day == null || monthDay == null) {
			return false;
		} else {
			return day.after(getFirstDayOfMonth(monthDay)) && day.before(getEndDayOfMonth(monthDay));
		}
	}

	/*
	 * 获得某月最后一天的日期 传入格式：yyyy-mm 返回格式：yyyy-mm-dd
	 */
	public static String getMaxDayOfMonth(String date) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1]), 1);
		c.add(Calendar.DAY_OF_YEAR, -1);
		return date + "-" + c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 通过时间粒度和日期获取所需的Timer参数
	 * 
	 * @param timeradio
	 * @param date
	 * @return params
	 */
	public static Object[] getTimerParams(String timeradio, String date) {
		// 时间起始点
		String begintime = "";
		// 时间结束点
		String endtime = "";
		Calendar calendar = Calendar.getInstance();// 日历对象
		SimpleDateFormat sdf = null;
		int n = 0;
		if ("days".equals(timeradio)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			if ("now".equals(date)) {
				begintime = sdf.format(calendar.getTime()) + " 00:00";
				endtime = sdf.format(calendar.getTime()) + " 23:59";
			} else {
				begintime = date + " 00:00";
				endtime = date + " 23:59";
			}
			timeradio = "hours";
		} else if ("mons".equals(timeradio)) {
			sdf = new SimpleDateFormat("yyyy-MM");
			if ("now".equals(date)) {
				begintime = sdf.format(calendar.getTime()) + "-01";
				endtime = DateUtils.getMaxDayOfMonth(sdf.format(calendar.getTime()));
			} else {
				begintime = date.split("-")[0] + "-" + date.split("-")[1] + "-01";
				endtime = DateUtils.getMaxDayOfMonth(date.split("-")[0] + "-" + date.split("-")[1]);
			}
			timeradio = "days";
			n = 1;
		} else {
			sdf = new SimpleDateFormat("yyyy");
			if ("now".equals(date)) {
				begintime = sdf.format(calendar.getTime()) + "-01-01";
				endtime = sdf.format(calendar.getTime()) + "-12-01";
			} else {
				begintime = date.split("-")[0] + "-01-01";
				endtime = date.split("-")[0] + "-12-01";
			}

			timeradio = "mons";
			n = 2;
		}
		// Hour单位
		String h = "";
		// 日起格式化截取起始
		int start = 0, end = 0;
		switch (n) {
		case 0:
			start = 11;
			end = 6;
			h = "H";
			break;
		case 1:
			start = 5;
			end = 9;
			h = "";
			break;
		case 2:
			start = 0;
			end = 12;
			h = "";
			break;
		}
		/**
		 * 返回值各个意义： begintime 查询依据 起始时间 endtime 查询依据 结束时间 start 格式化依据 起点 end
		 * 格式化依据 截点 h 格式化依据 Hour单位
		 */
		Object[] obj = { begintime, endtime, start, end, h };
		return obj;
	}

	/**
	 * 格式化显示的日期
	 * 
	 * @param dateStr
	 * @param start
	 * @param end
	 * @param h
	 * @return format string
	 */
	public static String formatDateShow(String dateStr, int start, int end, String h) {
		return (dateStr.substring(start, (dateStr.length() - end)) + h);
	}
}
