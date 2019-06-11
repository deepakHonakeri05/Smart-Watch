
package com.pro.deepak.smart_watch.connectivity;

public interface HttpListener {
	// Callback methods
	public void OnReceiveHttpResponse(int type, String strResult, int resultCode);
	public void OnReceiveFileResponse(int type, String id, String filepath, String url, int resultCode);
	
}
