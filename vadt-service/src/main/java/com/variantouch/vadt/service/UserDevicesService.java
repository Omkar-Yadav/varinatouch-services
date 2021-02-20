package com.variantouch.vadt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.variantouch.vadt.constants.Constants;
import com.variantouch.vadt.dao.UserDevicesRepository;
import com.variantouch.vadt.dto.Device;
import com.variantouch.vadt.dto.DeviceDetails;
import com.variantouch.vadt.dto.DevicesInRoom;
import com.variantouch.vadt.dto.Module;
import com.variantouch.vadt.dto.Room;
import com.variantouch.vadt.dto.UserDeviceDetails;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.UserDevices;
import com.variantouch.vadt.response.VTResponse;

@Service
public class UserDevicesService {

	public VTResponse<Map<String, List<UserDevices>>> getRoomDeviceWise(List<UserDevices> userdevices) {
		VTResponse<Map<String, List<UserDevices>>> vTResponse = new VTResponse<Map<String, List<UserDevices>>>();

		Map<String, List<UserDevices>> MappedDeviceList = new HashMap<String, List<UserDevices>>();
		List<UserDevices> Bedroom1 = new ArrayList<UserDevices>();
		List<UserDevices> Bedroom2 = new ArrayList<UserDevices>();
		List<UserDevices> Bedroom3 = new ArrayList<UserDevices>();
		List<UserDevices> Bedroom4 = new ArrayList<UserDevices>();
		List<UserDevices> Bedroom5 = new ArrayList<UserDevices>();
		List<UserDevices> DrawingRoom1 = new ArrayList<UserDevices>();
		List<UserDevices> DrawingRoom2 = new ArrayList<UserDevices>();
		List<UserDevices> Bathroom1 = new ArrayList<UserDevices>();
		List<UserDevices> Bathroom2 = new ArrayList<UserDevices>();
		List<UserDevices> Bathroom3 = new ArrayList<UserDevices>();
		List<UserDevices> Bathroom4 = new ArrayList<UserDevices>();
		List<UserDevices> Bathroom5 = new ArrayList<UserDevices>();
		List<UserDevices> Porch = new ArrayList<UserDevices>();
		List<UserDevices> Balcony = new ArrayList<UserDevices>();
		List<UserDevices> RoofTop1 = new ArrayList<UserDevices>();
		List<UserDevices> RoofTop2 = new ArrayList<UserDevices>();
		List<UserDevices> Kitchen1 = new ArrayList<UserDevices>();
		List<UserDevices> Kitchen2 = new ArrayList<UserDevices>();

		try {

			for (UserDevices userDevices2 : userdevices) {
				if (userDevices2.getRoom().getRoomName().equals(Constants.Bedroom1)) {
					Bedroom1.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Bedroom2)) {
					Bedroom2.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Bedroom3)) {

					Bedroom3.add(userDevices2);
				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Bedroom4)) {
					Bedroom4.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Bedroom5)) {
					Bedroom5.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.DrawingRoom1)) {
					DrawingRoom1.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.DrawingRoom2)) {
					DrawingRoom2.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.BathRoom1)) {
					Bathroom1.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.BathRoom2)) {
					Bathroom2.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.BathRoom3)) {
					Bathroom3.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.BathRoom4)) {
					Bathroom4.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.BathRoom5)) {
					Bathroom5.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.RoofTop1)) {
					RoofTop1.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.RoofTop2)) {
					RoofTop2.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Kitchen1)) {
					Kitchen1.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Kitchen2)) {
					Kitchen2.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Balcony)) {
					Balcony.add(userDevices2);

				}
				if (userDevices2.getRoom().getRoomName().equals(Constants.Porch)) {
					Porch.add(userDevices2);

				}
			}

			if (!Bedroom1.isEmpty())
				MappedDeviceList.put(Constants.Bedroom1, Bedroom1);
			if (!Bedroom2.isEmpty())
				MappedDeviceList.put(Constants.Bedroom2, Bedroom2);
			if (!Bedroom3.isEmpty())
				MappedDeviceList.put(Constants.Bedroom3, Bedroom3);
			if (!Bedroom4.isEmpty())
				MappedDeviceList.put(Constants.Bedroom4, Bedroom4);
			if (!Bedroom5.isEmpty())
				MappedDeviceList.put(Constants.Bedroom5, Bedroom5);
			if (!Bathroom1.isEmpty())
				MappedDeviceList.put(Constants.BathRoom1, Bathroom1);
			if (!Bathroom2.isEmpty())
				MappedDeviceList.put(Constants.BathRoom2, Bathroom2);
			if (!Bathroom3.isEmpty())
				MappedDeviceList.put(Constants.BathRoom3, Bathroom3);
			if (!Bathroom4.isEmpty())
				MappedDeviceList.put(Constants.BathRoom4, Bathroom4);
			if (!Bathroom5.isEmpty())
				MappedDeviceList.put(Constants.BathRoom5, Bathroom5);
			if (!Kitchen1.isEmpty())
				MappedDeviceList.put(Constants.Kitchen1, Kitchen1);
			if (!Kitchen2.isEmpty())
				MappedDeviceList.put(Constants.Kitchen2, Kitchen2);
			if (!Porch.isEmpty())
				MappedDeviceList.put(Constants.Porch, Porch);
			if (!DrawingRoom1.isEmpty())
				MappedDeviceList.put(Constants.DrawingRoom1, DrawingRoom1);
			if (!DrawingRoom2.isEmpty())
				MappedDeviceList.put(Constants.DrawingRoom2, DrawingRoom2);
			if (!Balcony.isEmpty())
				MappedDeviceList.put(Constants.Balcony, Balcony);
			if (!RoofTop1.isEmpty())
				MappedDeviceList.put(Constants.RoofTop1, RoofTop1);
			if (!RoofTop2.isEmpty())
				MappedDeviceList.put(Constants.RoofTop2, RoofTop2);

			vTResponse.setData(MappedDeviceList);

			return vTResponse;

		} catch (Exception e) {
			throw e;
		}

	}

	@Autowired
	UserDevicesRepository userDevicesRepository;

	public VTResponse<UserDeviceDetails> getDeviceDetails(Long userId) {
		VTResponse<UserDeviceDetails> response = new VTResponse<UserDeviceDetails>();
		UserDeviceDetails userDeviceDetails = new UserDeviceDetails();
		try {
			List<UserDevices> listOfUserDevices = userDevicesRepository.findDevicesByUserId(userId);
			if(!listOfUserDevices.isEmpty()) {
			DeviceDetails deviceDetails = new DeviceDetails();
			// List<DeviceDetails> listdeviceDetails = new ArrayList<DeviceDetails>();
			List<DevicesInRoom> listdeviceDetails = new ArrayList<DevicesInRoom>();
			for (UserDevices userDevices : listOfUserDevices) {
				DevicesInRoom devicesInRoom = new DevicesInRoom();
				devicesInRoom.setDevice(getDevice(userDevices.getDevice()));
				devicesInRoom.setId(userDevices.getId());
				devicesInRoom.setModule(getModule(userDevices.getModule()));
				devicesInRoom.setRoom(getRoom(userDevices.getRoom()));
				listdeviceDetails.add(devicesInRoom);
			}
			deviceDetails.setListOfDevicesInRoom(listdeviceDetails);
			userDeviceDetails.setDeviceDetails(deviceDetails);
			userDeviceDetails.setUserId(userId);
			response.setData(userDeviceDetails);
			} else {
				throw new BadRequestException("User with provided is is not available in the records");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	private Device getDevice(com.variantouch.vadt.model.Device device) {
		return new Device(device.getDeviceId(), device.getDefaultvalue(), device.getDeviceName(),
				device.getDeviceType(), device.getDevicestatus(), device.getDevicekind());

	}

	private Module getModule(com.variantouch.vadt.model.Module module) {
		return new Module(module.getModuleId(), module.getModuleIp());

	}

	private Room getRoom(com.variantouch.vadt.model.Room room) {
		return new Room(room.getRoomId(), room.getRoomName(), room.getRoomType());

	}

	public VTResponse<List<UserDevices>> saveDevices(List<UserDevices> userDevicesList) {
		VTResponse<List<UserDevices>> response = new VTResponse<List<UserDevices>>();
		response.setData(userDevicesRepository.saveAll(userDevicesList));
		return response;
	}

	public VTResponse<String> deleteDevices(UserDevices userDevice) {
		VTResponse<String> response = new VTResponse<String>();
		userDevicesRepository.delete(userDevice);
		response.setData("Dleted the record successfully");
		return response;
	}

	public VTResponse<UserDevices> editDevices(UserDevices userDevice) {
		VTResponse<UserDevices> response = new VTResponse<UserDevices>();
		response.setData(userDevicesRepository.saveAndFlush(userDevice));
		return response;
	}
}
