package com.devapp.activity.common;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.domain.User;
import com.devapp.http.ErrorInfo;
import com.devapp.http.ResponseHandler;
import com.devapp.manager.UserManager;
import com.devapp.utils.ActivityUtils;
import com.devapp.utils.ManagerFactory;
import com.devapp.utils.ViewUtils;

public class LoginActivity extends BaseActivity implements OnClickListener {
	
	private EditText mPhoneNumber;
	
	private EditText mPassword;
	
	private Button mLoginBtn;
	
	private Button mRegisterBtn;
	
	private UserManager userService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		
		//所有的service都不需要自己new，只需要通过工厂模式获取即可
		//通过id的方式获取服务
		//userService = (IUserService) ServiceFactory.getService(IBaseService.USER_SERVICE, this);
		
		userService = ManagerFactory.getUserService(this);
	}

	protected void initView() {
		mPhoneNumber = (EditText) findViewById(R.id.mPhoneNumber);
		mPassword = (EditText) findViewById(R.id.mPassword);
		mLoginBtn = (Button) findViewById(R.id.mLoginBtn);
		mRegisterBtn = (Button) findViewById(R.id.mRegisterBtn);
	}
	
	protected void setOnClickListener(){
		mLoginBtn.setOnClickListener(this);
		mRegisterBtn.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		 switch(v.getId()){
		 case R.id.mLoginBtn:
			 String phoneNumText = ViewUtils.getTextFromView(mPhoneNumber);
			 String passwordText = ViewUtils.getTextFromView(mPassword);
			 
			 login(phoneNumText, passwordText);
			 break;
		 case R.id.mRegisterBtn:
			 ActivityUtils.startActivity(this, RegisterActivity.class);
			 break;
		 }
	}

	private void login(String phoneNumText, String passwordText) {
		User user = new User(null,phoneNumText,passwordText);
		 userService.login(user, new ResponseHandler<User, Exception>() {
			
			@Override
			public void onSuccess(int status, User user,ErrorInfo errorInfo) {
				if(status == ErrorInfo.SUCCESS){
					//逻辑正确
					Toast.makeText(LoginActivity.this,"登陆成功", Toast.LENGTH_SHORT).show();
				}else{
					//处理错误
					Toast.makeText(LoginActivity.this,errorInfo.code+":"+errorInfo.msg, Toast.LENGTH_SHORT).show();
				}
			}
			
			@Override
			public void onError(Exception e) {
				  //处理请求异常
				Toast.makeText(LoginActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
