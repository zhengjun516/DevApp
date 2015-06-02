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
		sectionsMap.put(2, sections);
		
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "ScrollView";
		sections.add(section);
		sectionsMap.put(2, sections);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "ListView";
		sections.add(section);
		sectionsMap.put(2, sections);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "GridView";
		sections.add(section);
		sectionsMap.put(2, sections);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "Gallery";
		sections.add(section);
		sectionsMap.put(2, sections);
		
		section = new Section();
		section.id = 12;
		section.chapterId = chapterId;
		section.name = "菜单 Menu";
		sections.add(section);
		sectionsMap.put(2, sections);
		
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
