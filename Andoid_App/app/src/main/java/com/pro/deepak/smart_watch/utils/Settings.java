
package com.pro.deepak.smart_watch.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
	
	private static Settings mSettings = null;
	
	private Context mContext;
	
	
	
	public synchronized static Settings getInstance(Context c) {
		if(mSettings == null) {
			mSettings = new Settings(c);
		}
		return mSettings;
	}
	
	public Settings(Context c) {
		if(mContext == null) {
			mContext = c;
			initialize();
		}
	}
	
	
	private void initialize() {
	}
	
	
	public synchronized void finalize() {
		mContext = null;
		mSettings = null;
	}
	
	public synchronized void setGmailAddress(String addr) {
		if(addr != null && !addr.isEmpty()) {
			SharedPreferences prefs = mContext.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString(Constants.PREFERENCE_KEY_GMAIL_ADDRESS, addr);
			editor.commit();
		}
	}
	
	public synchronized String getGmailAddress() {
		SharedPreferences prefs = mContext.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return prefs.getString(Constants.PREFERENCE_KEY_GMAIL_ADDRESS, null);
	}
	
	public synchronized void setRunInBackground(boolean isTrue) {
		SharedPreferences prefs = mContext.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean(Constants.PREFERENCE_KEY_RUN_IN_BG, isTrue);
		editor.commit();
	}
	
	public synchronized boolean getRunInBackground() {
		SharedPreferences prefs = mContext.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return prefs.getBoolean(Constants.PREFERENCE_KEY_RUN_IN_BG, false);
	}
	
	
}
