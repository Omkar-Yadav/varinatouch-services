package com.variantouch.vadt.dto;

import lombok.Data;

@Data
public class Room{
    public Long roomId;
    public String roomName;
    public String roomType;
	public Room(Long roomId, String roomName, String roomType) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomType = roomType;
	}
}
