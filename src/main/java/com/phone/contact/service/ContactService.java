package com.phone.contact.service;

import java.util.List;

import com.phone.contact.entity.Contact;

public interface ContactService {
	
	public String saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public  Contact getContactbyId (Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContactById(Integer contactId);
	
	

}
