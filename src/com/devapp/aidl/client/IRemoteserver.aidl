package com.devapp.aidl.client;

interface IRemoteserver{
	String getRemoteMsg(int what);
	int getRemoteCode(String msg);
}