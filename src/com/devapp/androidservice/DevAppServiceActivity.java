package com.devapp.androidservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.devapp.activity.base.BaseActivity;

public class DevAppServiceActivity extends BaseActivity {
	
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	public void start(){
		Intent intent = new Intent(this,DevAppService.class);
		startService(intent);
	}
	
	public void stop(){
		Intent intent = new Intent(this,DevAppService.class);
		stopService(intent);
	}
	
	public void bind(){
		Intent intent = new Intent(this,DevAppService.class);
		bindService(intent, connection, Service.BIND_AUTO_CREATE);
	}
	
	public void unbind(){
		unbindService(connection);
	}
}
