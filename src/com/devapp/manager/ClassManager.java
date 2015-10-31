package com.devapp.manager;

import java.util.List;

import com.devapp.domain.Chapter;
import com.devapp.domain.Section;

public interface ClassManager extends BaseManager {
	public List<Chapter> getChapters();
	public List<Section> getSections(int chapterId);

}
