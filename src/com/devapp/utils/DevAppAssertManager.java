package com.devapp.utils;

import android.content.Context;

public class DevAppAssertManager {
	private Context mContext;

	public DevAppAssertManager(Context mContext) {
		this.mContext = mContext;
	}

	public void copyAssertFileToSDCard(){
		mContext.getAssets();
	}
}
