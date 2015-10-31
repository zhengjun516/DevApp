package com.devapp.utils;

import android.content.Context;

import com.devapp.manager.BaseManager;
import com.devapp.manager.MessageManager;
import com.devapp.manager.UserManager;
import com.devapp.manager.impl.ArticleManagerImpl;
import com.devapp.manager.impl.ClassManagerImpl;
import com.devapp.manager.impl.MessageManagerImpl;
import com.devapp.manager.impl.UserManagerImpl;

public class ManagerFactory {
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
	public static BaseManager getService(int id){
		switch(id){
		  case USER_SERVICE:
		  case BOOK_SERVICE:
		  case MESSAGE_SERVICE:
		  case ARTICLE_SERVICE:
			 return new ArticleManagerImpl();
		  default:return null;
		}
	}
	
	/**
	 * 通过具体名字获取服务
	 * @param context
	 * @return
	 */
	public static UserManager getUserService(Context context){
		return (UserManager) new UserManagerImpl(context);
	}
	
	public static MessageManager getMessageService(Context context){
		return new MessageManagerImpl(context);
	}
}
