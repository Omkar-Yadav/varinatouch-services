package com.variantouch.vadt.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VTResponse<T> {
	private T data;
	private VTError error;

}