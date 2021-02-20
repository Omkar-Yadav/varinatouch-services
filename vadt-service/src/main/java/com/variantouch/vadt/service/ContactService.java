package com.variantouch.vadt.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.ContactRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.exceptions.RecordNotFoundException;
import com.variantouch.vadt.model.Contact;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;
import static java.util.Objects.isNull;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	public VTResponse<Contact> getContact(Long id) {
		VTResponse<Contact> response = new VTResponse<Contact>();
		try {
			Contact contact = contactRepository.findByid(id);
			
			if (contact != null){
				response.setData(contact);
			} else {
				/*
				 * response.setError( new VTError(HttpStatus.NOT_FOUND.toString(),
				 * "Object not found with the provided id"));
				 */
				throw new RecordNotFoundException( "Object not found with the provided id");
			}
		
		} catch (EntityNotFoundException e) {
			throw new RecordNotFoundException( "Object not found with the provided id");
		}
		  catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Contact> getContactByEmialId(String emailId) {
		VTResponse<Contact> response = new VTResponse<Contact>();

		try {
			Contact contact = contactRepository.findByEmailId(emailId);
			if (contact == null) {
				throw new RecordNotFoundException("Record is not avaialable with specified emailId");
			} else {
				response.setData(contact);
			}
		} catch (Exception e) {
			throw e;	
		}
		return response;
	}

	public VTResponse<List<Contact>> getAllContacts() {
		VTResponse<List<Contact>> response = new VTResponse<List<Contact>>();
		try {
			List<Contact> list = contactRepository.findAll();
			response.setData(list);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Contact> saveContact(@RequestBody Contact contact) {
		VTResponse<Contact> response = new VTResponse<Contact>();
		try {
			if(contactRepository.findByid(contact.getId()) != null) {
				throw new BadRequestException("Record with specified id already exist");
			}
			else if(contactRepository.findByEmailId(contact.getEmailId()) != null) {
				throw new BadRequestException("Record with specified emailId already exist");
			}
			else {
				response.setData(contactRepository.save(contact));
				System.out.println("After executing the save contact");
			}
		} catch (Exception e) {
			throw e;
		}
		response.setData(contact);
		return response;
	}

	public VTResponse<Contact> editContact(@RequestBody Contact contact) {
		VTResponse<Contact> response = new VTResponse<Contact>();
		try {
			response.setData(contactRepository.save(contact));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteContact(@RequestBody Contact contact) {
		VTResponse<String> response = new VTResponse<String>();
		try {
			System.out.println("Before executing the delete contact");
			
			if(contactRepository.findByid(contact.getId()) != null) {
				contactRepository.delete(contact);
				response.setData("Deleted the resource successfully");
				System.out.println("After executing the delete contact");
			}
			else {
				throw new BadRequestException("Try providing correct data to get a successful response");
			}
			
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
