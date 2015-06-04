package com.devapp.download;

public class DownloadTaskListenerAdapter implements DownloadTaskListener{
    public void updateProcess(DownloadTask downloadTask){};			// 更新进度
    public void finishDownload(DownloadTask downloadTask){};			// 完成下载
    public void preDownload(){};					// 准备下载
    public void errorDownload(int error){};				// 下载错误
}
