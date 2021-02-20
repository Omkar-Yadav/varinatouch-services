package com.variantouch.vadt.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MessageAuto implements Serializable {
	
	 private static final long serialVersionUID = 8334816928170220333L;
	String msgId;
	String msgType;
	String text;
	String deviceId;
	String deviceType;
	String deviceName;
	String roomId;
	String roomName;
	String deviceStatus;
	String intensity;
	String currentDate;
	String hexValue;
	String timerValue;
	String webSocketClient;
	String temprature;
	String humidity;
	String powerStatus;
	String moduleId;
	String moduleIp;
	String motionStatus;
}
