package com.devapp.adapter.base;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devapp.activity.base.BaseFragment;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

	protected List<BaseFragment> mFragments;
	
	public BaseFragmentPagerAdapter(List<BaseFragment> fragments,FragmentManager fm){
		super(fm);
		if(fragments != null){
			this.mFragments = fragments;
		}else{
			this.mFragments = new ArrayList<BaseFragment>();
		}
	}
	
	public BaseFragmentPagerAdapter(FragmentManager fm) {
		this(null,fm);
	}

	@Override
	public Fragment getItem(int position) {
		if(mFragments != null){
			return (Fragment) mFragments.get(position);
		}
		return null;
	}

	@Override
	public int getCount() {
		if(mFragments != null){
			return mFragments.size();
		}
		return 0;
	}

	public Object addFragment(BaseFragment fragment){
		if(mFragments == null){
			mFragments = new ArrayList<BaseFragment>();
		}
		mFragments.add(fragment);
		return fragment;
	}
}
