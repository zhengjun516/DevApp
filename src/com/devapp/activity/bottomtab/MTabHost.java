package com.devapp.activity.bottomtab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TabHost;

/**
 * 
 * @author zhengjun1
 *
 */
public class MTabHost extends TabHost {

	/**
	 *从左向右   第一个TabItem
	 */
	public static final String TAB_ITEM1 = "tab_item1";
	public static final String TAB_ITEM2 = "tab_item2";
	public static final String TAB_ITEM3 = "tab_item3";
	public static final String TAB_ITEM4 = "tab_item4";
	
	public int tabItemCount = 0;
	
	public MTabHost(Context context) {
		super(context);
	}

	public MTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

}
