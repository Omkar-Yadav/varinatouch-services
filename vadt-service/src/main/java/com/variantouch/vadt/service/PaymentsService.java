package com.variantouch.vadt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.PaymentRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.Payment;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;

@Service
public class PaymentsService {

	@Autowired
	PaymentRepository paymentRepository;

	public VTResponse<Payment> getPayment(Long id) {
		VTResponse<Payment> response = new VTResponse<Payment>();

		try {
			response.setData(paymentRepository.findByid(id));
		} catch (Exception e) {
			 throw e;
		}
		return response;

	}

	public VTResponse<List<Payment>> getAllPayments() {
		VTResponse<List<Payment>> response = new VTResponse<List<Payment>>();
		try {
			response.setData(paymentRepository.findAll());
		} catch (Exception e) {
			 throw e;
		}
		return response;
	}

	public VTResponse<Payment> savePayment(@RequestBody com.variantouch.vadt.dto.Payment payment1) {
		VTResponse<Payment> response = new VTResponse<Payment>();
		try {
			Payment payment = new Payment();
			payment.setAmount(payment1.getAmount());
			payment.setId(payment1.getId());
			payment.setUser(payment1.getUser());
			if(paymentRepository.findByid(payment.getId() ) == null) {
				response.setData(paymentRepository.save(payment));
			} else {
				throw new BadRequestException("provided payment is already present in the records");
			}
		} catch (Exception e) {
		 throw e;
		}
		return response;
	}

	public VTResponse<Payment> editPayment(@RequestBody com.variantouch.vadt.dto.Payment payment1) {
		VTResponse<Payment> response = new VTResponse<Payment>();
		try {
			Payment payment = new Payment();
			payment.setAmount(payment1.getAmount());
			payment.setId(payment1.getId());
			payment.setUser(payment1.getUser());
			
			if(paymentRepository.findByid(payment.getId() ) == null) {
				throw new BadRequestException("provided payment is not present in the records");
			} else {
				response.setData(paymentRepository.save(payment));
			}
			
		} catch (Exception e) {
			 throw e;
		}
		return response;
	}

	public VTResponse<String> deletePayment(@RequestBody Payment payment) {
		VTResponse<String> response = new VTResponse<String>();
		try {
			
			if(paymentRepository.findByid(payment.getId() ) == null) {
				throw new BadRequestException("provided payment is not present in the records");
			} else {
				paymentRepository.delete(payment);
				response.setData("Deleted the record successfuly");
			}
		} catch (Exception e) {
			 throw e;
		}
		return response;
	}
}
