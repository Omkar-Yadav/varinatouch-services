package com.variantouch.vadt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeviceDetails{
    @JsonProperty("ListOfDevicesInRoom") 
    public List<DevicesInRoom> listOfDevicesInRoom;
}
