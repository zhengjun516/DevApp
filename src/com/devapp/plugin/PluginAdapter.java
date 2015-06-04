package com.devapp.plugin;

import java.io.File;
import java.util.List;

import com.devapp.R;
import com.devapp.adapter.base.MBaseAdapter;
import com.ryg.utils.DLUtils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PluginAdapter extends MBaseAdapter<PluginItem> {

	
	public PluginAdapter(Activity context) {
		super(context, null);
	}
	
	public PluginAdapter(Activity context, List<PluginItem> datas) {
		super(context, datas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 ViewHolder holder;
         if (convertView == null) {
             convertView = mInflater.inflate(R.layout.plugin_item, parent, false);
             holder = new ViewHolder();
             holder.appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
             holder.appName = (TextView) convertView.findViewById(R.id.app_name);
             holder.apkName = (TextView) convertView.findViewById(R.id.apk_name);
             holder.packageName = (TextView) convertView.findViewById(R.id.package_name);
             convertView.setTag(holder);
         } else {
             holder = (ViewHolder) convertView.getTag();
         }
         PluginItem item = (PluginItem) getItem(position);
         PackageInfo packageInfo = item.packageInfo;
         holder.appIcon.setImageDrawable(DLUtils.getAppIcon(mContext, item.pluginPath));
         holder.appName.setText(DLUtils.getAppLabel(mContext, item.pluginPath));
         holder.apkName.setText(item.pluginPath.substring(item.pluginPath.lastIndexOf(File.separatorChar) + 1));
         holder.packageName.setText(packageInfo.applicationInfo.packageName + "\n" + 
                                    item.launcherActivityName + "\n" + 
                                    item.launcherServiceName);
         return convertView;
	}
	
	private static class ViewHolder {
        public ImageView appIcon;
        public TextView appName;
        public TextView apkName;
        public TextView packageName;
    }
}
