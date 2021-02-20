package com.variantouch.vadt.dto;

import java.io.Serializable;

import com.variantouch.vadt.model.BaseEntity;
import com.variantouch.vadt.model.User;

import lombok.Data;

@Data
public class EnergyConsumption extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8334816928170220333L;

	private Long id;

	private String dateTime;

	private String power;

	private User user;

}
