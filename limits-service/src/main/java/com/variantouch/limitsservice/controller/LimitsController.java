package com.variantouch.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.variantouch.limitsservice.LimitsServiceProperties;
import com.variantouch.limitsservice.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	LimitsServiceProperties limitsServiceProperties;

	@GetMapping("/limits")
	public Limits getLimits() {
		System.out.println(limitsServiceProperties.getMaximum() +"  ---------------  "+limitsServiceProperties.getMinimum());
		return new Limits(limitsServiceProperties.getMaximum(), limitsServiceProperties.getMinimum());
	}
}
