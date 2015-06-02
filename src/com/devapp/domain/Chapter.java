package com.devapp.domain;

import java.io.Serializable;
import java.util.List;

import android.graphics.drawable.Drawable;

public class Chapter implements Serializable{
	public int id;
	public String name;
	public String[] imgUrls;
	public Drawable icon;
	public String content;

	public List<Section> sections;
}
