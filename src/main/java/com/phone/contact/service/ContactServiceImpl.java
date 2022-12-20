package com.phone.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.contact.entity.Contact;
import com.phone.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {

		contact.setActiveSw("ACTIVE");

		contact = repo.save(contact);
		if (contact.getContactId() != null) {
			return "Contact Saved";
		} else {
			return "Contact not Saved";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		//return repo.findaAll();
		return repo.findByActiveSw("ACTIVE");
	}

	@Override
	public Contact getContactbyId(Integer contactId) {

		Optional<Contact> find = repo.findById(contactId);
		if (find.isPresent()) {
			return find.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			Contact save = repo.save(contact);
			return "update Success";
		} else {
			return "No records Found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		// this logic is when you delete data in data base also delete the data
		// permanently
		/*
		 * if (repo.existsById(contactId)) { repo.deleteById(contactId); return
		 * "Records Deleted"; } else { return "No records Found"; }
		 */
		// this logic is when you delete data only delete the data temporally but in
		// database not deleted that data

		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("IN ACTIVE");
			repo.save(contact);
			return "Records Deleted";
		} else {
			return "No records Found";
		}
	}

}
