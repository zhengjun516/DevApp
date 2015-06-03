package com.devapp.activity.course;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.domain.IntentParam;
import com.devapp.fragment.SectionFragment;

public class ClassActivity extends BaseActivity {
	
	private SectionFragment sectionFragment;
	
	private FragmentManager manager;
	private FragmentTransaction transaction;
	private IntentParam intentParam;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		intentParam = (IntentParam) getIntent().getSerializableExtra(IntentParam.KEY);
		manager = getSupportFragmentManager();
		
		setContentView(R.layout.activity_class);
		sectionFragment = new SectionFragment();
		
		transaction = manager.beginTransaction();
		transaction.replace(R.id.mFragmentContainer, sectionFragment, "section");
		
		transaction.commit();
	}

}
