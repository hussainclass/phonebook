package com.ibm.phonebook.service;

import java.util.List;

import com.ibm.phonebook.entity.Contact;
import com.ibm.phonebook.exception.RecordNotFoundException;

public interface PhoneBookService {

	public List<Contact> getContactBySurName(String surname) throws RecordNotFoundException;

	public List<Contact> getAllContacts();

	public Contact createOrUpdateContact(Contact contact);

	public void deleteContactById(Long id) throws RecordNotFoundException;
}
