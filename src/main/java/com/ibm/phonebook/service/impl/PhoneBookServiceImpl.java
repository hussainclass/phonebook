package com.ibm.phonebook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.phonebook.entity.Contact;
import com.ibm.phonebook.exception.RecordNotFoundException;
import com.ibm.phonebook.repository.PhoneBookRepository;
import com.ibm.phonebook.service.PhoneBookService;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public PhoneBookServiceImpl() {
		
	}

	@Override
	public List<Contact> getContactBySurName(String surName) throws RecordNotFoundException {
		List<Contact> contacts = phoneBookRepository.findBySurName(surName);

		if (!contacts.isEmpty()) {
			return contacts;
		} else {
			throw new RecordNotFoundException("No contact record exist for given name");
		}
	}

	@Override
	public List<Contact> getAllContacts() {

		List<Contact> contactList = phoneBookRepository.findAll();

		if (contactList.size() > 0) {
			return contactList;
		} else {
			return new ArrayList<Contact>();
		}
	}

	@Override
	public Contact createOrUpdateContact(Contact contact) {
		Contact newContact = null;
		if (contact.getId() != null) {
			Optional<Contact> dbContact = phoneBookRepository.findById(contact.getId());

			if (dbContact.isPresent()) {
				newContact = dbContact.get();

				DozerBeanMapper mapper = new DozerBeanMapper();
				newContact = mapper.map(contact, Contact.class);
				newContact = phoneBookRepository.save(newContact);
			}
			return newContact;
		} else {
			newContact = phoneBookRepository.save(contact);
			return newContact;
		}
	}

	@Override
	public void deleteContactById(Long id) throws RecordNotFoundException {

		Optional<Contact> contact = phoneBookRepository.findById(id);

		if (contact.isPresent()) {
			phoneBookRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No contact record exist for given id");
		}
	}

}
