package com.devapp.broadcast;

import com.devapp.domain.IntentParam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DevAppBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		IntentParam param = (IntentParam) intent.getSerializableExtra(IntentParam.KEY);
		
	}

}
