package com.variantouch.vadt.dto;

import lombok.Data;

@Data
public class Device{
    public Long deviceId;
    public String defaultvalue;
    public String deviceName;
    public String deviceType;
    public Boolean devicestatus;
    public char devicekind;
	public Device(Long deviceId, String defaultvalue, String deviceName, String deviceType, Boolean devicestatus,
			char devicekind) {
		super();
		this.deviceId = deviceId;
		this.defaultvalue = defaultvalue;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.devicestatus = devicestatus;
		this.devicekind = devicekind;
	}
}