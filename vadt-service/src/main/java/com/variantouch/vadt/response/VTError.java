package com.variantouch.vadt.response;

import lombok.Data;

@Data
public class VTError {
	public VTError(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	private String errCode;
	private String errMsg;

}