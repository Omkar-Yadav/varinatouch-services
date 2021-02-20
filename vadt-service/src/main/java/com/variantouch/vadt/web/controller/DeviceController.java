package com.variantouch.vadt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.variantouch.vadt.model.Device;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.DeviceService;

@RestController
@RequestMapping("/vtadmin/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(path = "/getAllDevices", produces = "application/json")
	public VTResponse<List<Device>> getAllDevices() {
		return deviceService.getAllDevices();
	}

	@GetMapping(path = "/getDevice/{deviceid}", produces = "application/json")
	public VTResponse<Device> getDevice(@PathVariable(name = "deviceid", required = true) long id) {
		return deviceService.getDevice(id);
	}

	@PostMapping(path = "/saveDevice", produces = "application/json")
	public VTResponse<Device> saveDevice(@RequestBody Device device) {
		return deviceService.saveDevice(device);
	}

	@PutMapping(path = "/editDevice", produces = "application/json")
	public VTResponse<Device> editDevice(@RequestBody Device device) {
		return deviceService.editDevice(device);
	}

	@DeleteMapping(path = "/deleteDevice", produces = "application/json")
	public VTResponse<String> deleteDevice(@RequestBody Device device) {
		return deviceService.deleteDevice(device);
	}

}
