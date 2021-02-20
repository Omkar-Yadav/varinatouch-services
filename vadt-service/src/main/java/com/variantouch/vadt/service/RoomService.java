package com.variantouch.vadt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.RoomRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.Room;
import com.variantouch.vadt.response.VTResponse;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	public VTResponse<Room> getRoom(Long id) {
		VTResponse<Room> response = new VTResponse<Room>();

		try {
			response.setData(roomRepository.findByid(id));
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	public VTResponse<List<Room>> getAllRooms() {
		VTResponse<List<Room>> response = new VTResponse<List<Room>>();
		try {
			response.setData(roomRepository.findAll());
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Room> saveRoom(@RequestBody Room room) {
		VTResponse<Room> response = new VTResponse<Room>();
		try {
			if (roomRepository.findByid(room.getRoomId()) == null)
				response.setData(roomRepository.save(room));
			else {
				throw new BadRequestException("Provided room is already present in the records");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Room> editRoom(@RequestBody Room room) {
		VTResponse<Room> response = new VTResponse<Room>();
		try {
			if (roomRepository.findByid(room.getRoomId()) != null)
				response.setData(roomRepository.save(room));
			else {
				throw new BadRequestException("Provided room is not present in the records");
			}
			response.setData(roomRepository.saveAndFlush(room));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteRoom(@RequestBody Room room) {
		VTResponse<String> response = new VTResponse<String>();
		try {
			if (roomRepository.findByid(room.getRoomId()) != null) {
				roomRepository.delete(room);
				response.setData("Deleted the record successfully");
			} else {
				throw new BadRequestException("Provided room is not present in the records");
			}
			return response;
		} catch (Exception e) {
			throw e;
		}

	}
}
