

package com.pro.deepak.smart_watch.contents.objects;

public class EmergencyObject {
	public static final int EMERGENCY_TYPE_NONE = 0;
	public static final int EMERGENCY_TYPE_CALL_STATE = 1;
	public static final int EMERGENCY_TYPE_RF_STATE = 2;
	public static final int EMERGENCY_TYPE_BATT_STATE = 3;
	public static final int EMERGENCY_TYPE_USER_DEFINED = 4;
	
	public static final int CALL_STATE_IDLE = 0;
	public static final int CALL_STATE_CALL_RECEIVED = 1;
	
	public static final int RF_STATE_IN_SERVICE = 0;
	public static final int RF_STATE_OUT_OF_SERVICE = 1;
	public static final int RF_STATE_EMERGENCY_ONLY = 2;
	public static final int RF_STATE_POWER_OFF = 3;
	
	public static final int WIFI_STATE_ACTIVATED = 0;
	public static final int WIFI_STATE_DISABLED = 1;
	
	public static final int BATT_STATE_UNKNOWN = 0;
	public static final int BATT_STATE_AC_CHARGING = 1;
	public static final int BATT_STATE_USB_CHARGING = 2;
	public static final int BATT_STATE_DISCHARGING = 3;
	public static final int BATT_STATE_NOT_CHARGING = 4;
	public static final int BATT_STATE_FULL = 5;
	
}
