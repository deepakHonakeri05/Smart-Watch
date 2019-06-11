
package com.pro.deepak.smart_watch.contents.objects;

public class NotificationObject {
	public int mId;
	public String mPackageName = null;
	public String mText = null;
	
	public NotificationObject(int id, String packageName, String text) {
		this.mId = id;
		this.mPackageName = packageName;
		this.mText = text;
	}
}
