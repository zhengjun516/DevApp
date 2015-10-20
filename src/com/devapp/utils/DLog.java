/**
 * <p>Title: MyLog.java</p>
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2011 by 
 * Beijing Freefly, Beijing, China
 * All rights reserved.</p>
 * <p>Company: Freefly</p>
 * @author wangsq
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   Lester wangsq, 2009-9-16
 * <U>Description:</U>  Update description
 * </PRE>
 */
package com.devapp.utils;

import android.util.Log;

public class DLog {
	private static final boolean DEBUG = true;

	public static void d(String tag, String msg) {
		if (DEBUG) Log.d(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (DEBUG) Log.e(tag, msg);
	}
	
	public static void e(String tag, String msg, Throwable e) {
		if (DEBUG) Log.e(tag, msg, e);
	}
	
	public static void i(String tag, String msg) {
		if (DEBUG) Log.i(tag, msg);
	}
}
