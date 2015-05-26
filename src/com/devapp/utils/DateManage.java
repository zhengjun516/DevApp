/**
 * <p>Title: DateManage.java</p>
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2011 by
 * beijing Freefly, beijing, China
 * All rights reserved.</p>
 * <p>Company: freefly</p>
 * @author wangsq
 * @version 1.0
 * @see
 *
 * <PRE>
 * <U>Updated by:</U>   Lester wangsq, Nov 14, 2008
 * <U>Description:</U>  Update description
 * </PRE>
 */
package com.devapp.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kajilen
 *
 */
public class DateManage {

	/**
	 *
	 */
	public DateManage() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String strDate;
		int iDay = -14;
		long Odds = 0;
		DateManage dbm = new DateManage();
		strDate = dbm.GetLastDate(iDay);

		Odds = DateManage.GetTimeOdds("20110408154600", "20110408155000");*/
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String ConvertDateToLong(String date) {
		String curDate = "";
		Date dateSrc = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat dfSrc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			dateSrc = dfSrc.parse(date);
			
			if(dateSrc != null)
			{
			    curDate = df.format(dateSrc);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return curDate;
	}
	/**
	 * 获得指定天数之前的日期
	 *
	 * @param iDay
	 *            倒退的天数
	 * @return String iDay天之前的日期
	 */
	public String GetLastDate(int iDay) {
		String lastDate = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - iDay);

		lastDate = df.format(now.getTime());

		return lastDate;
	}
	
	/**
	 * 获得指定天数之前的日期
	 *
	 * @param iDay
	 *            倒退的天数
	 * @return String iDay天之前的日期
	 */
	public static String GetLastDateTime(int iDay) {
		String lastDate = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - iDay);

		lastDate = df.format(now.getTime());

		return lastDate;
	}

	public static long GetTimeOdds(String timep, String times)
	{
		long lOdds = 0;
		SimpleDateFormat smdf = new SimpleDateFormat( "yyyyMMddHHmmss");
		try {
			Date start = smdf.parse(timep);
			Date end = smdf.parse(times);

			lOdds = (end.getTime() - start.getTime()) / (60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			lOdds = -1;
		}
		return lOdds;
	}
	
	public static long GetTimeDay(String timep, String times)
	{
		long lOdds = 0;
		SimpleDateFormat smdf = new SimpleDateFormat( "yyyyMMdd");
		try {
			Date start = smdf.parse(timep);
			Date end = smdf.parse(times);

			lOdds = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			lOdds = -1;
		}
		return lOdds;
	}
	
	public static long GetDayOdds(String timep, String times)
	{
		long lOdds = 0;
		SimpleDateFormat smdf = new SimpleDateFormat( "yyyyMMddHHmmss");
		try {
			Date start = smdf.parse(timep);
			Date end = smdf.parse(times);

			lOdds = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			lOdds = -1;
		}
		return lOdds;
	}

	/**
	 * 获得指定天数之前的日期
	 *
	 * @param iDay
	 *            倒退的天数
	 * @return String iDay天之前的日期
	 */
	public static String GetAfterDate(String strDay, int iDay) {
		String lastDate = null;

		Date d;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			d = df.parse(strDay);

			Calendar now = Calendar.getInstance();
			now.setTime(d);
			now.set(Calendar.DATE, now.get(Calendar.DATE) + iDay);

			lastDate = df.format(now.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return lastDate;
	}

	/**
	 * 获得指定天数之前的日期
	 *
	 * @param iDay
	 *            倒退的天数
	 * @return String iDay天之前的日期
	 */
	public static String GetLastDateLong(int iDay) {
		String lastDate = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - iDay);

		lastDate = df.format(now.getTime());

		return lastDate;
	}

	/**
	 * 获得指定天数之前的格式化后的日期
	 *
	 * @param iDay
	 *            倒退的天数
	 * @return String iDay天之前的日期
	 */
	public String GetCompareDate(int iDay) {
		String strCmpDate = null;

		strCmpDate = GetLastDate(iDay);

		strCmpDate += "00";

		return strCmpDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurDateLong() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		curDate = df.format(new Date());

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurDateMonth() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");

		curDate = df.format(new Date());

		return curDate;
	}
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static int GetCurDateInt() {
		int iDate = 0;
		Date date = null;
		String curDate = "";

		date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		curDate = df.format(date);
		if(curDate == null)
		{
			curDate = "";
		}

		iDate = Integer.valueOf(curDate);

		return iDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static int GetCurMonthInt() {
		int iDate = 0;

		String strMonth = "";

		strMonth = GetCurDateMonth();

		if(strMonth == null)
		{
			strMonth = "";
		}

		iDate = Integer.valueOf(strMonth);

		return iDate;
	}
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurrentDate() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		curDate = df.format(new Date());

		return curDate;
	}
	
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurrentDateMonth() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

		curDate = df.format(new Date());

		return curDate;
	}
	
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurrentDay() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		curDate = df.format(new Date());

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurMonth() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("MM");

		curDate = df.format(new Date());

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurDate() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");

		curDate = df.format(new Date());

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetCurDateMin() {
		String curDate = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");

		curDate = df.format(new Date());

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetFormatDateTime(String strDate) {
		String curDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date olddate = null;

		try {
			olddate = new Date(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");

		curDate = df.format(olddate);

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetFormatDate(String strDate) {
		String curDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date olddate = null;

		try {
			olddate = new Date(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");

		curDate = df.format(olddate);

		return curDate;
	}
	
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String GetFormatT(String strDate) {
		String curDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date olddate = null;

		try {
			olddate = new Date(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		curDate = df.format(olddate);

		return curDate;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static Timestamp GetTimeStamp() {
		Timestamp timestamp;

		timestamp = new Timestamp(new Date().getTime());

		return timestamp;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static Timestamp GetTimeStampByString(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Timestamp timestamp = null;
		Date olddate = null;

		try {
			olddate = sdf.parse(strDate);

			timestamp = new Timestamp(olddate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return timestamp;
	}

	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String  GetTimeStamp(Timestamp time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		Date date = time;

		return sdf.format(date);
	}
	/**
	 * 获得当前天的时间点
	 *
	 * @return String 获得当前日期
	 */
	public static String  GetTimeStampFormat2(Timestamp time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = time;

		return sdf.format(date);
	}
}
