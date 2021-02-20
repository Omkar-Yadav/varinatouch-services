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

import com.variantouch.vadt.model.Room;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.RoomService;

@RestController
@RequestMapping("/vtadmin/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping(path = "/getAllRooms", produces = "application/json")
	public VTResponse<List<Room>> getAllRooms() {
		return roomService.getAllRooms();
	}

	@GetMapping(path = "getRoom/{roomid}", produces = "application/json")
	public VTResponse<Room> getRoom(@PathVariable(name = "roomid", required = true) long id) {
		return roomService.getRoom(id);
	}

	@PostMapping(path = "/saveRoom", produces = "application/json")
	public VTResponse<Room> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@PutMapping(path = "/editRoom", produces = "application/json")
	public VTResponse<Room> editRoom(@RequestBody Room room) {
		return roomService.editRoom(room);
	}

	@DeleteMapping(path = "/deleteRoom", produces = "application/json")
	public VTResponse<String> deleteRoom(@RequestBody Room room) {
		return roomService.deleteRoom(room);
	}

}
