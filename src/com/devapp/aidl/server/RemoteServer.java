package com.devapp.aidl.server;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

/**
 * 服务端远程服务，客户端通过对该服务的访问，
 * 进而获取IRemoteserverImpl（对AIDL的实现，其中的2个方法）
 *
 * 客户端和服务端工程分别新建一个aidl接口，所在包和文件名必须一样
 * 
 * 
 * 需要在manifest中注册，供外部绑定使用
 * manifest中注册的action，就是客户端绑定的时候intent需要添加的action
 * <service
            android:name="com.teffy.aidldemo.service.RemoteServer"
            android:process=":remote" >  表示该服务远程调用服务
            <intent-filter >
            	// 过滤器action
                <action android:name="com.teffy.aidldemo.aidl.IRemoteServer"/>
            </intent-filter>
        </service>
 * 
 * 
 * @Package_Name : com.teffy.aidldemo.service
 * @ClassName: RemoteServerService
 * @author lumeng
 * @date 2014-1-25 上午10:37:44
 * @version V1.0
 */
public class RemoteServer extends Service {
	public static final String TAG = "RemoteServer";

	/**
	 * 对AIDL的具体实现，该服务被绑定之后就返回一个IRemoteserverImpl对象（IBinder），具体见onBind方法中
	 * 
	 * @Package_Name : com.teffy.aidldemo.service
	 * @ClassName: IServiceImpl
	 * @author lumeng
	 * @date 2014-1-25 上午10:48:28
	 * @version V1.0
	 */
	public class IRemoteserverImpl extends IRemoteserver.Stub {
		@Override
		public String getRemoteMsg(int what) throws RemoteException {
			String msg = "Message Test";
			switch (what) {
			case 1:
				msg = "Message --> One--" + what;
				break;
			case 2:
				msg = "Message --> Two--" + what;
				break;
			case 3:
				msg = "Message --> Three--" + what;
				break;

			default:
				break;
			}
			return msg;
		}

		@Override
		public int getRemoteCode(String msg) throws RemoteException {
			if (!TextUtils.isEmpty(msg)) {
				return 100;
			}
			return 0;
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "onCreate");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind");
		return new IRemoteserverImpl();
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		Log.i(TAG, "onRebind");
	}

	
	
}
