package com.devapp.aidl.client;

import com.devapp.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * 客户端绑定程序
 * 客户端src中必须包含一个 和服务端工程分别新建一个aidl接口，所在包和文件名必须一样
 * 
 * @Package_Name : com.teffy.aidlclient
 * @ClassName: MainActivity
 * @author lumeng
 * @date 2014-2-8 下午11:04:21
 * @version V1.0
 */
public class AIDLClientActivity extends Activity implements OnClickListener{
	
	private Button bt_bind,bt_unbind,bt_test_int,bt_test_str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aidl_client);
		
		bt_bind = (Button) findViewById(R.id.bt_bind);
		bt_unbind = (Button) findViewById(R.id.bt_unbind);
		bt_test_int = (Button) findViewById(R.id.bt_test_int);
		bt_test_str = (Button) findViewById(R.id.bt_test_str);
		
		bt_bind.setOnClickListener(this);
		bt_unbind.setOnClickListener(this);
		bt_test_int.setOnClickListener(this);
		bt_test_str.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	IRemoteserver iRemoteserver;
	/**
	 * 服务连接
	 */
	ServiceConnection serviceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i("MainActivity", "onServiceDisconnected");
			iRemoteserver = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i("MainActivity", "onServiceConnected");			
			iRemoteserver = IRemoteserver.Stub.asInterface(service);
		}
	};
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_bind:
			// 绑定服务
			bindAIDLservice();
			break;
		case R.id.bt_unbind:
			// 解绑服务
			unbindService(serviceConnection);
			break;
		case R.id.bt_test_int:
			// 判断AIDL接口是不是空
			if(iRemoteserver == null){
				Toast.makeText(getApplicationContext(), "请先绑定", 0).show();
				return;
			}else{
				try {
					
					Toast.makeText(getApplicationContext(), String.valueOf(iRemoteserver.getRemoteCode("aa")), 0).show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			break;
		case R.id.bt_test_str:
			if(iRemoteserver == null){
				Toast.makeText(getApplicationContext(), "请先绑定", 0).show();
				return;
			}else{
				try {
					Toast.makeText(getApplicationContext(), String.valueOf(iRemoteserver.getRemoteMsg((count++)%3)), 0).show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			break;

		default:
			break;
		}
	}
	/**
	 * 绑定服务
	 * 
	 * @param 
	 * @return void
	 * @throws
	 */
	private void bindAIDLservice() {
		Bundle args = new Bundle();  
        Intent intent = new Intent("com.teffy.aidldemo.aidl.IRemoteServer");  
        intent.putExtras(args);  
        bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);  
	}

	int count = 0;
}
