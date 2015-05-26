package com.devapp.activity.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.domain.User;
import com.devapp.http.ErrorInfo;
import com.devapp.http.ResponseHandler;
import com.devapp.service.IUserService;
import com.devapp.utils.ActivityUtils;
import com.devapp.utils.MyObjectUtils;
import com.devapp.utils.ServiceFactory;
import com.devapp.utils.ViewUtils;

public class RegisterActivity extends BaseActivity implements OnClickListener {
	
	public final int CHOOSE_SCHOOL_REQUEST_CODE = 1;
	
	private EditText mPhoneNumber;
	
	private EditText mPassword;
	
	private Button mRegisterBtn;
	
	private TextView mSchool;
	
	private IUserService userService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();
		setOnClickListener();
		
		//userService = (IUserService) ServiceFactory.getService(IBaseService.USER_SERVICE, this);
		userService = ServiceFactory.getUserService(this);
		
		
	}

	protected void initView() {
		mPhoneNumber = (EditText) findViewById(R.id.mPhoneNumber);
		mPassword = (EditText) findViewById(R.id.mPassword);
		mRegisterBtn = (Button) findViewById(R.id.mRegisterBtn);
		mSchool = (TextView) findViewById(R.id.mSchool);
	}

	protected void setOnClickListener() {
		mRegisterBtn.setOnClickListener(this);
		mSchool.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
       switch(v.getId()){
           case R.id.mRegisterBtn:
        	   String phoneNumberText = ViewUtils.getTextFromView(mPhoneNumber);
        	   String passwordText = ViewUtils.getTextFromView(mPassword);
        	  
		       register(phoneNumberText, passwordText);
    	   break;
       }		
	}

	/**
	 * 注册
	 * @param phoneNumberText
	 * @param passwordText
	 */
	private void register(String phoneNumberText, String passwordText) {
		User user = new User(null,phoneNumberText, passwordText,0);
		   userService.register(user,new ResponseHandler<User, Exception>() {
			
			@Override
			public void onSuccess(int status, User t, ErrorInfo errorInfo) {
				if(status == ErrorInfo.SUCCESS){
					//逻辑正确
				}else{
					//处理错误
					Toast.makeText(RegisterActivity.this,errorInfo.code+":"+errorInfo.msg, Toast.LENGTH_SHORT).show();
				}
			}
			
			@Override
			public void onError(Exception e) {
				 //处理请求异常
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
		case CHOOSE_SCHOOL_REQUEST_CODE:
			if(MyObjectUtils.isEmptyObject(data)){
				return;
			}
			break;
		}
	}

}
