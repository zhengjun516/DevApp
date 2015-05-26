package com.devapp.http;

public interface ResponseHandler<T,E> {
	public static final int SUCCESS = 200;
	
	void onSuccess(int status,T t,ErrorInfo errorInfo);
	
	void onError(E e);

}
