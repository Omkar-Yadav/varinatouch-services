package com.variantouch.vadt.dto;

import lombok.Data;

@Data
public class Module {
	
	public Long moduleId;
	public String moduleIp;
	public Module(Long moduleId, String moduleIp) {
		super();
		this.moduleId = moduleId;
		this.moduleIp = moduleIp;
	}
	
}
