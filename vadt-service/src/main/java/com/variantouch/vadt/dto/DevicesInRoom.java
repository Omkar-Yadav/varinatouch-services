package com.variantouch.vadt.dto;

import lombok.Data;

@Data
public class DevicesInRoom{
    public Long id;
    public Device device;
    public Room room;
    public Module module;
}
