package com.variantouch.vadt.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.UserRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.Contact;
import com.variantouch.vadt.model.EnergyConsumption;
import com.variantouch.vadt.model.Payment;
import com.variantouch.vadt.model.User;
import com.variantouch.vadt.response.VTResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public VTResponse<User> getUser(Long id) {
		VTResponse<User> response = new VTResponse<User>();

		try {
			response.setData(userRepository.findByid(id));
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	public VTResponse<User> getUserByEmailId(String emailId) {
		VTResponse<User> response = new VTResponse<User>();
		try {
			response.setData(userRepository.findByEmailId(emailId));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<List<User>> getAllUsers() {
		VTResponse<List<User>> response = new VTResponse<List<User>>();
		try {
			response.setData(userRepository.findAll());
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<User> saveUser(@RequestBody User user) {
		VTResponse<User> response = new VTResponse<User>();
		try {
			if (user.getPayments() == null) {
				user.setPayments(Collections.<Payment>emptySet());
				// user.setPayments( new HashSet<Payment>() );
			}
			if (user.getContacts() == null) {
				user.setContacts(Collections.<Contact>emptySet());
				// user.setContacts( new HashSet<Contact>() );
			}
			if (user.getEnergyConsumptions() == null) {
				user.setEnergyConsumptions(Collections.<EnergyConsumption>emptySet());
				// user.setEnergyConsumptions( new HashSet<EnergyConsumption>() );
			}
			if (userRepository.findByid(user.getId()) == null
					|| userRepository.findByEmailId(user.getEmailId()) == null) {
				response.setData(userRepository.saveAndFlush(user));
			} else {
				throw new BadRequestException(
						"The provided User is already available in the records please check for id or email");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Integer> editUser(@RequestBody User user) {
		VTResponse<Integer> response = new VTResponse<Integer>();
		try {
			User user1 = userRepository.findByid(user.getId()); 
			if (user1 != null) {
				response.setData(userRepository.updateUser(user.getEmailId(), user.getId()));
			} else {
				throw new BadRequestException("The provided User is not available in the records");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteUser(@RequestBody User user) {
		VTResponse<String> response = new VTResponse<String>();
		try {
			if (userRepository.findByid(user.getId()) != null) {
				userRepository.delete(user);
				response.setData("Deleted the record successfully");
			} else {
				throw new BadRequestException("The provided User is not available in the records");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
