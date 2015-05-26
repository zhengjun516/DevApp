package com.devapp.activity.bottomtab;

import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.google.inject.Inject;

/**
 * Tab导航模式的基本框架
 * @author zhengjun1
 *
 */
public class MainTabActivity extends BaseActivity {


	public MTabHost mTabHost;
	
	public RelativeLayout mTabLayout;
	
	public TabWidget mTabs;
	
	private TabManager mTabManager;
	
	@Inject
	private LayoutInflater inflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tab);
		inflater = LayoutInflater.from(this);
		initTab();
	}

	private void initTab() {
		
		mTabHost.setup();
		mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
		
		View item1 = inflater.inflate(R.layout.main_tab_item, null);
		View item2 = inflater.inflate(R.layout.main_tab_item, null);
		View item3 = inflater.inflate(R.layout.main_tab_item, null);
		View item4 = inflater.inflate(R.layout.main_tab_item, null);
		
		setImageResoure(item1, R.drawable.main_tab_item_icon1_selector);
		setImageResoure(item2, R.drawable.main_tab_item_icon2_selector);
		setImageResoure(item3, R.drawable.main_tab_item_icon3_selector);
		setImageResoure(item4, R.drawable.main_tab_item_icon4_selector);
		
		mTabManager.addTab(mTabHost.newTabSpec(MTabHost.TAB_ITEM1).setIndicator(item1), Tab1Fragment.class, 1);
		mTabManager.addTab(mTabHost.newTabSpec(MTabHost.TAB_ITEM2).setIndicator(item2), Tab2Fragment.class, 2);
		mTabManager.addTab(mTabHost.newTabSpec(MTabHost.TAB_ITEM3).setIndicator(item3), Tab3Fragment.class, 3);
		mTabManager.addTab(mTabHost.newTabSpec(MTabHost.TAB_ITEM4).setIndicator(item4), Tab4Fragment.class, 4);
	}
	
	private void setImageResoure(View view,int id){
		if(view == null){
			return;
		}
		ImageView imageView = (ImageView) view.findViewById(R.id.icon);
		imageView.setImageResource(id);
	}
	
	public static class TabManager implements TabHost.OnTabChangeListener{
		
		private final FragmentActivity mActivity;
		private final TabHost mTabHost;
		private final int mContainerId;
		private final HashMap<String, TabInfo> mTabs = new HashMap<String, TabInfo>();
		TabInfo mLastTab;
		
		static final class TabInfo {
			private final String tag;
			private final Class<?> clazz;
			private final int index;
			private Fragment fragment;
			
			TabInfo(String _tag, Class<?> _class, int index) {
				tag = _tag;
				clazz = _class;
				this.index = index;
			}
		}
		
		static class DummyTabFactory implements TabHost.TabContentFactory {
			private final Context mContext;
			
			public DummyTabFactory(Context context) {
				mContext = context;
			}
			
			@Override
			public View createTabContent(String tag) {
				View v = new View(mContext);
				v.setMinimumWidth(0);
				v.setMinimumHeight(0);
				return v;
			}
		}
		
		
		public TabManager(FragmentActivity mActivity, TabHost mTabHost,int mContainerId) {
			this.mActivity = mActivity;
			this.mTabHost = mTabHost;
			this.mContainerId = mContainerId;
			mTabHost.setOnTabChangedListener(this);
		}

		public void addTab(TabHost.TabSpec tabSpec,Class<?> clazz,int args){
			tabSpec.setContent(new DummyTabFactory(mActivity));
			
			String tag = tabSpec.getTag();
			TabInfo info = new TabInfo(tag, clazz, args);
			
			info.fragment = mActivity.getSupportFragmentManager().findFragmentByTag(tag);
			
			if (info.fragment != null && !info.fragment.isDetached()) {
				FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
				ft.detach(info.fragment);
				// ft.commit();
				ft.commitAllowingStateLoss();
			}
			
			mTabs.put(tag, info);
			mTabHost.addTab(tabSpec);
		}

		@Override
		public void onTabChanged(String tabId) {
			TabInfo newTab = mTabs.get(tabId);
			if (mLastTab != newTab) {
				FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
				
				if (mLastTab != null) {
					if (mLastTab.index > newTab.index) {
						ft.setCustomAnimations(R.anim.push_right_in, R.anim.push_right_out);
					} else {
						ft.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
					}
				}
				
				if (mLastTab != null) {
					if (mLastTab.fragment != null) {
						ft.hide(mLastTab.fragment);
					}
				}
				if (newTab != null) {
					if (newTab.fragment == null || newTab.fragment.getView() == null) {
						newTab.fragment = Fragment.instantiate(mActivity, newTab.clazz.getName(), null);
						ft.add(mContainerId, newTab.fragment, newTab.tag);
					} else {
						ft.show(newTab.fragment);
					}
				}
				
				mLastTab = newTab;
				ft.commitAllowingStateLoss();
				
				mActivity.getSupportFragmentManager().executePendingTransactions();
			}
		}
	} 
}
