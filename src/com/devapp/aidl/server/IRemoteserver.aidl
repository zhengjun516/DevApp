package com.devapp.aidl.server;
// AIDL文件，定义了2个方法，只要该文件写法正确，那么在gen目录下就会生成相应的java文件
interface IRemoteserver{
	String getRemoteMsg(int what);
	int getRemoteCode(String msg);
}