package com.varinatouch.authenticationservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.varinatouch.authenticationservice.dao.UserRepository;
import com.varinatouch.authenticationservice.dto.User;

@Service
public class UsersDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = null;
		// return new User("foo","foo", new ArrayList<>());
		try {
			user = userRepository.findByEmailId(userName);
			if (user != null) {
				return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),
						new ArrayList<>());
			} else {
				throw new Exception("User with provided details is not present in the records");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("user not found");
		}

	}

}
