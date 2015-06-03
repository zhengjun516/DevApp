package com.devapp.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.devapp.activity.base.BaseActivity;

/**
 * @author SYSTEM
 *
 */
public class BroadCastReceiverActivity extends BaseActivity {

	private DevAppBroadcastReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		receiver = new DevAppBroadcastReceiver();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.intent.action.DEVAPP");
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}

    public void send(View view) {  
        Intent intent = new Intent("android.intent.action.DEVAPP");  
        intent.putExtra("msg", "hello receiver.");  
        sendBroadcast(intent);  
    }  
}
