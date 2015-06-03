package com.devapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devapp.domain.Chapter;
import com.devapp.domain.Section;
import com.devapp.service.ClassService;

public class ClassServiceImpl extends BaseServiceImpl implements ClassService{
	
	private List<Chapter> chapters = new ArrayList<Chapter>();
	
	private Map<Integer,List<Section>> sectionsMap = new HashMap<Integer, List<Section>>();
	
	public ClassServiceImpl() {
		initChapters();
		initSections();
	}
	
	public List<Chapter> getChapters(){
		return chapters;
	}


	@Override
	public List<Section> getSections(int chapterId) {
		
		return sectionsMap.get(chapterId);
	}
	
	
	private void initChapters() {
		Chapter category = new Chapter();
		category.id = 1;
		category.name = "开发环境搭建";
		
		Chapter category2 = new Chapter();
		category2.id = 2;
		category2.name = "Android开发基础";
		
		Chapter category3 = new Chapter();
		category3.id = 3;
		category3.name = "Android UI";
		
		Chapter category4 = new Chapter();
		category4.id = 4;
		category4.name = "Android 数据存储";
		
		Chapter category5 = new Chapter();
		category5.id = 5;
		category5.name = "Android 网络通信";
		
		Chapter category6 = new Chapter();
		category6.id = 6;
		category6.name = "Android 多媒体";
		
		Chapter category7 = new Chapter();
		category7.id = 7;
		category7.name = "Android 图形图像";
		
		Chapter category8 = new Chapter();
		category8.id = 8;
		category8.name = "Android 高级";
		
		Chapter category9 = new Chapter();
		category9.id = 9;
		category9.name = "Android 游戏开发";
		
		Chapter category10 = new Chapter();
		category10.id = 10;
		category10.name = "Android 设备功能";
		
		Chapter category11 = new Chapter();
		category11.id = 11;
		category11.name = "Android 第三方集成";
		
		
		chapters.add(category);
		chapters.add(category2);
		chapters.add(category3);
		chapters.add(category4);
		chapters.add(category5);
		chapters.add(category6);
		chapters.add(category7);
		chapters.add(category8);
		chapters.add(category9);
		chapters.add(category10);
		chapters.add(category11);
	}
	
	public void initSections(){
		initsection1();
		initsection2();
		initsection3();
		initsection4();
		initsection5();
		initsection6();
		initsection7();
		initsection8();
		initsection9();
		initsection10();
		initsection11();
	}
	
	/**
	 * 
    微博(34)
    OAuth(13)
    Google 服务/API(58)
    支付宝(3)
    百度地图集成(41)
	 */
	private void initsection11() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 11;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "微博";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "微信";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "QQ";
		sections.add(section);
		
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "OAuth";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "支付宝";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "微信支付";
		sections.add(section);
		
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "百度地图";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "高德地图";
		sections.add(section);

		sectionsMap.put(chapterId, sections);
	}

	/**
	 * 
    GPS/LBS/定位(108)
    传感器(35)
    电话 API(73)
    短信/彩信/SMS/MMS(103)
    联系人/Contacts(40)
    设备信息(119)
    Android驱动开发(24)
	 */
	private void initsection10() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 10;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = " GPS/LBS/定位";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "传感器";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "电话 API";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "短信/彩信/SMS/MMS";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "联系人/Contacts";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "设备信息";
		sections.add(section);
		
		sectionsMap.put(chapterId, sections);
	}

	private void initsection9() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 9;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "游戏引擎";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = " 游戏示例/源码";
		sections.add(section);

		sectionsMap.put(chapterId, sections);
	}

	/**
	 * 
    编译/反编译(66)
    Android加密解密(13)
    OPhone(12)
    Web应用开发平台(99)
    Android安全(3)
    程序优化(65)
    APK程序信息(88)
    NDK/JNI(175)
    Android 框架/底层(164)
    源码下载/编译(143)
    程序移植(43)
	 */
	private void initsection8(){
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 8;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "编译/反编译";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "Android加密解密";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "Web应用开发平台";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "Android安全";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "程序优化";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "APK程序信息";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "NDK/JNI";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "Android 框架/底层";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = " 程序移植";
		sections.add(section);

		sectionsMap.put(chapterId, sections);
	}
	
	private void initsection7() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 7;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "OpenGL/3D";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "Canvas/Bitmap";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "Gif/动画";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "图像处理/特效";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "像素/屏幕/分辨率";
		sections.add(section);

		sectionsMap.put(chapterId, sections);
	}
	
	private void initsection6() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 6;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "音频/Audio";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "视频/Video";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "录音";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "摄像头/Camera";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "闹钟";
		sections.add(section);
		
		section = new Section();
		section.id = 6;
		section.chapterId = chapterId;
		section.name = "语音识别/文本朗读";
		sections.add(section);
		
		section = new Section();
		section.id = 7;
		section.chapterId = chapterId;
		section.name = "MediaStore";
		sections.add(section);

		sectionsMap.put(chapterId, sections);
	}

	private void initsection5() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 5;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "HTTP";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "Email";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "Socket";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "近场通信/nfc";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "Wifi/3G";
		sections.add(section);
		
		section = new Section();
		section.id = 6;
		section.chapterId = chapterId;
		section.name = "红外/蓝牙";
		sections.add(section);
		
		section = new Section();
		section.id = 7;
		section.chapterId = chapterId;
		section.name = "消息推送";
		sections.add(section);
		
		section = new Section();
		section.id = 8;
		section.chapterId = chapterId;
		section.name = "Web服务/RPC";
		sections.add(section);
		
		sectionsMap.put(chapterId, sections);
	}
	
	private void initsection4() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 4;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "媒体库";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "文件存储/SD卡";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "数据库/Sqlite";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "SharedPreference";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "ContentProvider";
		sections.add(section);
		sectionsMap.put(chapterId, sections);
	}
	
	private void initsection3() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 3;
		
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "Lanucher";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "手势操作";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "Widget";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "选择器Picker";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "EditText";
		sections.add(section);
		
		section = new Section();
		section.id = 6;
		section.chapterId = chapterId;
		section.name = "Button";
		sections.add(section);
		
		section = new Section();
		section.id = 7;
		section.chapterId = chapterId;
		section.name = "ImageView";
		sections.add(section);
		
		section = new Section();
		section.id = 8;
		section.chapterId = chapterId;
		section.name = "TextView";
		sections.add(section);
		
		section = new Section();
		section.id = 9;
		section.chapterId = chapterId;
		section.name = "CheckBox";
		sections.add(section);
		
		section = new Section();
		section.id = 10;
		section.chapterId = chapterId;
		section.name = "Dialog/PopupWindow";
		sections.add(section);
		
		section = new Section();
		section.id = 11;
		section.chapterId = chapterId;
		section.name = "Toast";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "ProgressBar";
		sections.add(section);
		
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "ScrollView";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "ListView";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "GridView";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "Gallery";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "菜单 Menu";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "SerfaceView";
		sections.add(section);
		sectionsMap.put(chapterId, sections);
	}

	private void initsection2() {
		List<Section> sections = new ArrayList<Section>();
		int chapterId = 2;
		Section section = new Section();
		section.id = 1;
		section.chapterId = chapterId;
		section.name = "Android四大组件之Activity";
		sections.add(section);
		
		section = new Section();
		section.id = 2;
		section.chapterId = chapterId;
		section.name = "Android四大组件之Service";
		sections.add(section);
		
		section = new Section();
		section.id = 3;
		section.chapterId = chapterId;
		section.name = "Android四大组件之BroadCastReceiver";
		sections.add(section);
		
		section = new Section();
		section.id = 4;
		section.chapterId = chapterId;
		section.name = "Android四大组件之ContentProvider";
		sections.add(section);
		
		section = new Section();
		section.id = 5;
		section.chapterId = chapterId;
		section.name = "Intent";
		sections.add(section);
		
		section = new Section();
		section.id = 6;
		section.chapterId = chapterId;
		section.name = "AndroidManifalst文件";
		sections.add(section);
		
		section = new Section();
		section.id = 7;
		section.chapterId = chapterId;
		section.name = "View";
		sections.add(section);
		
		section = new Section();
		section.id = 8;
		section.chapterId = chapterId;
		section.name = "程序资源/Resoure、assets";
		sections.add(section);
		
		section = new Section();
		section.id = 9;
		section.chapterId = chapterId;
		section.name = "线程间通信/Handler、Message、Looper";
		sections.add(section);
		
		section = new Section();
		section.id = 10;
		section.chapterId = chapterId;
		section.name = "进程间通信/AIDL";
		sections.add(section);
		
		section = new Section();
		section.id = 11;
		section.chapterId = chapterId;
		section.name = "按键、软键盘、输入法";
		sections.add(section);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "签名/打包/部署/发布";
		sections.add(section);
		sectionsMap.put(chapterId, sections);
	}
	

	private void initsection1() {
	}
}
