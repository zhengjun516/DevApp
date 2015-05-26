package com.devapp.utils;


public class ServiceProxyFactory{
	public static final int NET_SERVICE_PROXY = 1;
	public static final int DB_SERVICE_PROXY = 2;
	
	public static Object getServiceProxy(int type){
		switch(type){
		  case NET_SERVICE_PROXY:
			return new NetServiceProxy();
		  case DB_SERVICE_PROXY:
			  
		  default:
			return null;
		}
	}

}
