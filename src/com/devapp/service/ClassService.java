package com.devapp.service;

import java.util.List;

import com.devapp.domain.Chapter;
import com.devapp.domain.Section;

public interface ClassService extends BaseService {
	public List<Chapter> getChapters();
	public List<Section> getSections(int chapterId);

}
