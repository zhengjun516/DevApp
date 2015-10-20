package com.devapp.utils;

import android.content.Context;

import com.devapp.service.BaseService;
import com.devapp.service.MessageService;
import com.devapp.service.UserService;
import com.devapp.service.impl.ArticleServiceImpl;
import com.devapp.service.impl.ClassServiceImpl;
import com.devapp.service.impl.MessageServiceImpl;
import com.devapp.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static final int USER_SERVICE = 1;
	public static final int BOOK_SERVICE = 2;
	public static final int MESSAGE_SERVICE = 3;
	public static final int ARTICLE_SERVICE = 4;
	public static final int CLASS_SERVICE = 5;
	
	/**
	 * 通过id形式获取服务，与通过名字获取服务效果一样，根据个人喜好使用
	 * @param id
	 * @param mContext
	 * @return
	 */
	public static BaseService getService(int id){
		switch(id){
		  case USER_SERVICE:
		  case BOOK_SERVICE:
		  case MESSAGE_SERVICE:
		  case ARTICLE_SERVICE:
			 return new ArticleServiceImpl();
		  default:return null;
		}
	}
	
	/**
	 * 通过具体名字获取服务
	 * @param context
	 * @return
	 */
	public static UserService getUserService(Context context){
		return (UserService) new UserServiceImpl(context);
	}
	
	public static MessageService getMessageService(Context context){
		return new MessageServiceImpl(context);
	}
}
