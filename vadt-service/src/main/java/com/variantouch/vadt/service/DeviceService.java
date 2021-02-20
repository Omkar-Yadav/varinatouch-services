package com.variantouch.vadt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.DeviceRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.Device;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	public VTResponse<Device> getDevice(Long id) {
		VTResponse<Device> response = new VTResponse<Device>();
		try {
			response.setData(deviceRepository.findByid(id));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<List<Device>> getAllDevices() {
		VTResponse<List<Device>> response = new VTResponse<List<Device>>();
		try {
			response.setData(deviceRepository.findAll());
		} catch (Exception e) {
			VTError vTError = new VTError("error", "errMsg");
			response.setError(vTError);
		}
		return response;
	}

	public VTResponse<Device> saveDevice(@RequestBody Device device) {
		VTResponse<Device> response = new VTResponse<Device>();
		try {
			if (deviceRepository.findByid(device.getDeviceId()) == null) {
				response.setData(deviceRepository.save(device));
			} else {
				throw new BadRequestException("Object with the provided id is already present");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Device> editDevice(@RequestBody Device device) {
		VTResponse<Device> response = new VTResponse<Device>();
		try {
			if (deviceRepository.findByid(device.getDeviceId()) != null) {
				response.setData(deviceRepository.save(device));
			} else {
				throw new BadRequestException("Object with the provided id is not available");
			}
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestException("Reverify the request body for desired fields");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteDevice(@RequestBody Device device) {
		System.out.println("The device is is" + device.getDeviceId());
		VTResponse<String> response = new VTResponse<String>();
		try {
			if (deviceRepository.findByid(device.getDeviceId()) == null) {
				throw new BadRequestException("Reqeusted object is not present in the database");
			}
			deviceRepository.delete(device);
			response.setData("Deleted the record successfuly.");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}
}
