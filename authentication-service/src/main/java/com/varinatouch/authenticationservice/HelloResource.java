package com.varinatouch.authenticationservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varinatouch.authenticationservice.jwt.JwtUtil;
import com.varinatouch.authenticationservice.jwt.resources.JwtTokenRequest;
import com.varinatouch.authenticationservice.jwt.resources.JwtTokenResponse;
import com.varinatouch.authenticationservice.service.UsersDetailsService;

@RestController
public class HelloResource {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsersDetailsService usersDetailsService;

	@Autowired
	JwtUtil jwtUtil;

	@RequestMapping({ "/hello" })
	public String hello() {
		return "hello World";
	}

	@PostMapping(value = "${jwt.get.token.uri}")
	public ResponseEntity<?> authenticate(@RequestBody JwtTokenRequest jwtTokenRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtTokenRequest.getUsername(),
					jwtTokenRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid credentials");
		}
		final UserDetails userDetails = usersDetailsService.loadUserByUsername(jwtTokenRequest.getUsername());

		final String jwtToken = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtTokenResponse(jwtToken));

	}
	
	@GetMapping(value = "${jwt.refresh.token.uri}")
	public ResponseEntity<?> refresh(HttpServletRequest request) throws Exception {
		String authToken = request.getHeader("Authorization");
		final String token= authToken.substring(7);
		String userName = jwtUtil.extractUsername(token);
		final UserDetails userDetails =   usersDetailsService.loadUserByUsername(userName);

		if(jwtUtil.canTokenBeRefreshed(token)) {
			String jwtToken = jwtUtil.refreshToken(token);
			return ResponseEntity.ok(new JwtTokenResponse(jwtToken)); 
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}

	}

}
