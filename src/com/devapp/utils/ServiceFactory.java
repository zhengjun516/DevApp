package com.devapp.utils;

import android.content.Context;

import com.devapp.service.IBaseService;
import com.devapp.service.IBookService;
import com.devapp.service.IMessageService;
import com.devapp.service.IUserService;
import com.devapp.service.impl.BookServiceImpl;
import com.devapp.service.impl.MessageServiceImpl;
import com.devapp.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static final int USER_SERVICE = 1;
	public static final int BOOK_SERVICE = 2;
	public static final int MESSAGE_SERVICE = 3;
	/**
	 * 通过id形式获取服务，与通过名字获取服务效果一样，根据个人喜好使用
	 * @param id
	 * @param context
	 * @return
	 */
	public static IBaseService getService(int id,Context context){
		switch(id){
		  case USER_SERVICE:
			  return  new UserServiceImpl(context);
		  case BOOK_SERVICE:
			  return new BookServiceImpl(context);
		  case MESSAGE_SERVICE:
			  return new MessageServiceImpl(context);
		  default:return null;
		}
	}
	
	/**
	 * 通过具体名字获取服务
	 * @param context
	 * @return
	 */
	public static IUserService getUserService(Context context){
		return (IUserService) new UserServiceImpl(context);
	}
	
	public static IBookService getBookService(Context context){
		return new BookServiceImpl(context);
	}
	
	public static IMessageService getMessageService(Context context){
		return new MessageServiceImpl(context);
	}
}
