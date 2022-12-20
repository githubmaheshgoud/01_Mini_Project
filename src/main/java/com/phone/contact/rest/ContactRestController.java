package com.phone.contact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.contact.entity.Contact;
import com.phone.contact.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "this is contact api ")
public class ContactRestController {
	@Autowired
	private ContactService service;

	// http://localhost:8080/contact
	@PostMapping("/contact")
	@ApiOperation("this method is store the data ")
	public String createContact(@RequestBody Contact contact) {
		String status = service.saveContact(contact);
		return status;
	}

	// http://localhost:8080/contacts
	@GetMapping("/contacts")
	@ApiOperation("this method is used to display the data ")
	public List<Contact> getAllContact() {
		return service.getAllContacts();
	}

	// http://localhost:8080/contact/101
	@GetMapping("/contact/{contactId}")
	@ApiOperation("this is used to find the data through Id")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactbyId(contactId);
	}

	// http://localhost:8080/contact/
	@PutMapping("/contact")
	@ApiOperation("this is used to update the data ")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}

	// http://localhost:8080/contact/101
	@DeleteMapping("/contact/{contactId}")
	@ApiOperation("this is used to delete the data ")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}

}
