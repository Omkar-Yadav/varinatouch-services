package com.variantouch.vadt.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.variantouch.vadt.dto.DeviceDetails;
import com.variantouch.vadt.dto.UserDeviceDetails;
import com.variantouch.vadt.model.UserDevices;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.UserDevicesService;

@RestController
@RequestMapping("/vtadmin/userDevice")
public class UserDevicesController {

	@Autowired
	private com.variantouch.vadt.dao.UserDevicesRepository deviceInfoRepository;

	@Autowired
	private UserDevicesService userDevicesService;

	@PostMapping(path = "/savedevice", produces = "application/json")
	public UserDevices savedevice(@RequestBody UserDevices userDevices) {
		return deviceInfoRepository.saveAndFlush(userDevices);
	}
	
	
	@PutMapping(path = "/editdevice", produces = "application/json")
	public VTResponse<UserDevices> editdevice(@RequestBody UserDevices userDevice) {
		//deviceInfoRepository.saveAndFlush(userDevice);
		return userDevicesService.editDevices(userDevice);
	}
	
	@PostMapping(path = "/savedevices", produces = "application/json")
	public VTResponse<List<UserDevices>> savedevices(@RequestBody List<UserDevices> userDevicesList) {
		return userDevicesService.saveDevices(userDevicesList);
	}
	
	@DeleteMapping(path = "/deletedevice", produces = "application/json")
	public VTResponse<String> deletedevice(@RequestBody UserDevices userDevice) {
		return userDevicesService.deleteDevices(userDevice);
	}

//	@GetMapping(path = "/getall", produces = "application/json")
//	public List<com.variantouch.vadt.model.UserDevices> getUserDevices() {
//		return deviceInfoRepository.findAll();
//	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public VTResponse<Map<String, List<UserDevices>>> getDeviceInfo(@PathVariable Long id) {
		List<com.variantouch.vadt.model.UserDevices> userdevices = deviceInfoRepository.findDevicesByUserId(id);
		VTResponse<Map<String, List<UserDevices>>> AllDataDevices = userDevicesService.getRoomDeviceWise(userdevices);
		return AllDataDevices;
	}

	@GetMapping(path = "/test/{userid}", produces = "application/json")
	public VTResponse<Map<String, List<UserDevices>>> getDeviceInfoForUser(
			@PathVariable(name = "userid", required = true) Long userid) {
		List<com.variantouch.vadt.model.UserDevices> userdevices = deviceInfoRepository
				.findDevicesByUserId(userid);
		VTResponse<Map<String, List<UserDevices>>> AllDataDevices = userDevicesService.getRoomDeviceWise(userdevices);
		return AllDataDevices;
	}
	
	
	@GetMapping(path = "/getdevices/{userid}", produces = "application/json")
	public VTResponse<UserDeviceDetails> getDeviceInfo1(
			@PathVariable(name = "userid", required = true) Long userId) {
		return userDevicesService.getDeviceDetails(userId);
	}
	
}
