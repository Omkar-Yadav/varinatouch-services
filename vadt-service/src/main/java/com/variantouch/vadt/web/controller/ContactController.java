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

import com.variantouch.vadt.model.Contact;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.ContactService;

@RestController
@RequestMapping("/vtadmin/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping(path = "/getAllContacts", produces = "application/json")
	public VTResponse<List<Contact>> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping(path = "getContact/{contactId}", produces = "application/json")
	public VTResponse<Contact> getContact(@PathVariable(name = "contactId", required = true) long id) {
		return contactService.getContact(id);
	}
	
	@GetMapping(path = "getContactByEmailId/{emailId}", produces = "application/json")
	public VTResponse<Contact> getContactByEmailId(@PathVariable(name = "emailId", required = true) String emailId) {
		return contactService.getContactByEmialId(emailId);
	}

	@PostMapping(path = "/saveContact", produces = "application/json")
	public VTResponse<Contact> saveContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}

	@PutMapping(path = "/editContact", produces = "application/json")
	public VTResponse<Contact> editContact(@RequestBody Contact contact) {
		return contactService.editContact(contact);
	}

	@DeleteMapping(path = "/deleteContact", produces = "application/json")
	public VTResponse<String> deleteContact(@RequestBody Contact contact) {
		return contactService.deleteContact(contact);
	}
}
