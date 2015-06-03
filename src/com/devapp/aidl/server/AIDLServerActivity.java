package com.devapp.aidl.server;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;

public class AIDLServerActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aidl_server);
		
		new Thread(){
			public void run() {
				SystemClock.sleep(3000);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(getApplicationContext(), "thread", 0).show();
					}
				});
			};
		}.start();
		
		
	}
}
