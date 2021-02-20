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

import com.variantouch.vadt.model.User;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.UserService;

@RestController
@RequestMapping("/vtadmin/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(path = "/getAllUsers", produces = "application/json")
	public VTResponse<List<User>> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "getUser/{userid}", produces = "application/json")
	public VTResponse<User> getUser(@PathVariable(name = "userid", required = true) long id) {
		return userService.getUser(id);
	}

	@PostMapping(path = "/saveUser", produces = "application/json")
	public VTResponse<User> saveUser(@RequestBody User user) {
		System.out.println("userobject values" + user.getEmailId());
		return userService.saveUser(user);
	}

	@PutMapping(path = "/editUser", produces = "application/json")
	public VTResponse<Integer> editUser(@RequestBody User user) {
		return userService.editUser(user);
	}

	@DeleteMapping(path = "/deleteUser", produces = "application/json")
	public VTResponse<String> deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}

	@GetMapping(path = "/getUserByEmailId/{emailid}", produces = "application/json")
	public VTResponse<User> getUserByEmailId(@PathVariable(name = "emailid", required = true) String emailid) {
		return userService.getUserByEmailId(emailid);
	}
}
