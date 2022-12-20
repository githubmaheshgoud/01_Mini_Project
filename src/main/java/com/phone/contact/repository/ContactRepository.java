package com.phone.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public List<Contact> findByActiveSw(String status);
}
