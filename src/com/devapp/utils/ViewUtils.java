package com.devapp.utils;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewUtils {

	public static String getTextFromView(TextView textView){
		if(!MyObjectUtils.isEmptyObject(textView)){
			return textView.getText().toString().trim();
		}
		return "";
	}
	
	public static boolean validateFormField(String[] tips,EditText ...editTexts){
		if(MyObjectUtils.isEmptyObject(editTexts) || editTexts.length <= 0){
			return false;
		}
		
		if(MyObjectUtils.isEmptyObject(tips) || tips.length != editTexts.length){
			return false;
		}
		
		if(TextUtils.isEmpty(ViewUtils.getTextFromView(editTexts[0]))){
			return false;
		}
		return false;
	}
}
