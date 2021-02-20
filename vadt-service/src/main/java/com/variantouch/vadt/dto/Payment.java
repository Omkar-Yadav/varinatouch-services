package com.variantouch.vadt.dto;

import com.variantouch.vadt.model.User;

import lombok.Data;

@Data
public class Payment {
	private long id;

	private String amount;

	User user;

	public Payment(long id, String amount, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.user = user;
	}
}
