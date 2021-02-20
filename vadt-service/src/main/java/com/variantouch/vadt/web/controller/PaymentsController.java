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

import com.variantouch.vadt.model.Payment;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.PaymentsService;

@RestController
@RequestMapping("/vtadmin/payment")
public class PaymentsController {
	@Autowired
	private PaymentsService paymentService;

	@GetMapping(path = "/getAllPayments", produces = "application/json")
	public VTResponse<List<Payment>> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping(path = "getPayment/{paymentid}", produces = "application/json")
	public VTResponse<Payment> getPayment(@PathVariable(name = "paymentid", required = true) long id) {
		return paymentService.getPayment(id);
	}

	@PostMapping(path = "/savePayment", produces = "application/json")
	public VTResponse<Payment> savePayment(@RequestBody com.variantouch.vadt.dto.Payment payment) {
		return paymentService.savePayment(payment);
	}

	@PutMapping(path = "/editPayment", produces = "application/json")
	public VTResponse<Payment> editPayment(@RequestBody com.variantouch.vadt.dto.Payment payment) {
		return paymentService.editPayment(payment);
	}

	@DeleteMapping(path = "/deletePayment", produces = "application/json")
	public VTResponse<String> deletePayment(@RequestBody Payment payment) {
		return paymentService.deletePayment(payment);
	}

}
