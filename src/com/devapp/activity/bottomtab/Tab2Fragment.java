package com.devapp.activity.bottomtab;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.base.BaseFragment;
import com.devapp.adapter.ChapterAdapter;
import com.devapp.domain.Chapter;
import com.devapp.domain.IntentParam;
import com.devapp.service.ClassService;
import com.devapp.utils.ServiceFactory;

/**
 * 一起
 * @author zhengjun1
 *
 */
public class Tab2Fragment extends BaseFragment{
	private ListView mItemList;
	private ClassService categoryService;
	private ChapterAdapter itemsAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		View root = getView();
		mItemList = (ListView) root.findViewById(R.id.mItemList);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	/*	categoryService = (ClassService) ServiceFactory.getService(ServiceFactory.CLASS_SERVICE);
		List<Chapter> categories = categoryService.getChapters();
		itemsAdapter = new ChapterAdapter(mParentActivity, categories);
		mItemList.setAdapter(itemsAdapter);
		mItemList.setOnItemClickListener(new OnMyItemClickListenr(mParentActivity));*/
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_chapter, null);
	}

	@Override
	public void onResume() {
		super.onResume();
		
	}
	
	class OnMyClickListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			  case R.id.mRightBtn:
				break;
			}
		}
	}
	
	
	class OnMyItemClickListenr implements OnItemClickListener{
		private BaseActivity activity;
		
		public OnMyItemClickListenr(BaseActivity activity) {
			this.activity = activity;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		    Chapter chapter = (Chapter) parent.getItemAtPosition(position);
			IntentParam intentParams = new IntentParam();
			intentParams.put("chapter", chapter);
		}
	}
	
}
