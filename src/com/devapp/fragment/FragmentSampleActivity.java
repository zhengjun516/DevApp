package com.devapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;

/**
 * 1,查询Fragment
 * 2,添加Fragment
 * 3,替换Fragment
 * 4,删除Fragment
 * 5,向Fragment传递数据
 * @author SYSTEM
 */
public class FragmentSampleActivity extends BaseActivity {

	FrameLayout mFragmentContainer;
	
	FragmentManager manager;
	
	FragmentDemo1 fragment1;
	FragmentDemo2 fragment2;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	     setContentView(R.layout.activity_fragment);
		
		manager = getSupportFragmentManager();
		
		fragment1 = new FragmentDemo1();
		fragment2 = new FragmentDemo2();
		
	}
	
    public void find(){
		
	}
	
    public void remove(){
    	manager.beginTransaction().remove(fragment1);
		
	}
    public void add(){
		
	}
    
    public void hide(){
		
	}
    
    public void show(){
    	
    }
	
	public void replace(){
		manager.beginTransaction().replace(R.id.mFragmentContainer, fragment1).commit();
	}
	
}
