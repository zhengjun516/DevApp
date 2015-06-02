package com.devapp.fragment;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;
import com.devapp.adapter.SectionAdapter;
import com.devapp.domain.Chapter;
import com.devapp.domain.IntentParam;
import com.devapp.domain.Section;
import com.devapp.service.ClassService;
import com.devapp.utils.IntentParamManager;
import com.devapp.utils.ServiceFactory;

public class SectionFragment extends BaseFragment {
	
	private ListView mItemList;
	private SectionAdapter sectionAdapter;
	
	private List<Section> sections;
	private ClassService classService;
	
	private IntentParam intentParam;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_section, container, false);
	}



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mItemList = (ListView) getView().findViewById(R.id.mItemList);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		classService = (ClassService) ServiceFactory.getService(ServiceFactory.CLASS_SERVICE);
		intentParam = IntentParamManager.get(IntentParam.KEY);
		
		Chapter chapter = (Chapter) intentParam.get("chapter");
		
		if(chapter != null){
			sections = classService.getSections(chapter.id);
		}else{
			sections = classService.getSections(1);
		}
		sectionAdapter = new SectionAdapter(mParentActivity, sections);
		mItemList.setAdapter(sectionAdapter);
	}
	
	

	@Override
	public void onResume() {
		super.onResume();
	}
}