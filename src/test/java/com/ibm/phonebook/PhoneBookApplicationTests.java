package com.ibm.phonebook;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.phonebook.entity.Address;
import com.ibm.phonebook.entity.Contact;
import com.ibm.phonebook.exception.RecordNotFoundException;
import com.ibm.phonebook.repository.PhoneBookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneBookApplicationTests {

	@Test
	public void contextLoads() {
	}

	@InjectMocks
	com.ibm.phonebook.service.impl.PhoneBookServiceImpl PhoneBookServiceImpl;

	@Mock
	PhoneBookRepository dao;

	@Test
	public void createPhoneBookTest() {
		Contact contact = new Contact(null, "surname1", "firstname1", "123456789", null);

		PhoneBookServiceImpl.createOrUpdateContact(contact);

		verify(dao, times(1)).save(contact);
	}

	@Test
	public void deletePhoneBookTest() throws RecordNotFoundException {

		Contact contact = new Contact(1L, "surname1", "firstname1", "123456789", null);
		when(dao.findById(1L)).thenReturn(Optional.of(contact));

		PhoneBookServiceImpl.deleteContactById(Long.valueOf("1"));
		dao.delete(contact);
		verify(dao, times(1)).delete(contact);
	}

	@Test
	public void updatePhoneBookEntryTest() {

		Address addr = new Address();
		addr.setAddrLine1("addrLine1");
		addr.setAddrLine2("addrLine2");
		addr.setCity("BA");
		addr.setCountry("India");

		Contact contact = new Contact(1L, "surname1", "firstname1", "123456789", addr);

		when(dao.findById(1L)).thenReturn(Optional.of(contact));

		dao.save(contact);
		verify(dao, times(1)).save(contact);

	}

	@Test
	public void getPhoneBookAllEntriesTest() {

		Contact c1 = new Contact(1L, "surname1", "firstname1", "123456789", null);
		Contact c2 = new Contact(1L, "surname2", "firstname2", "987654321", null);
		List<Contact> listContacts = new ArrayList<Contact>();
		listContacts.add(c1);
		listContacts.add(c2);

		when(dao.findAll()).thenReturn(listContacts);

		assertEquals(2, PhoneBookServiceImpl.getAllContacts().size());
	}

	@Test
	public void findBySurNameTest() throws RecordNotFoundException {
		Contact c1 = new Contact(1L, "surname1", "firstname1", "123456789", null);

		List<Contact> listContacts = new ArrayList<Contact>();
		listContacts.add(c1);

		when(dao.findBySurName("surname1")).thenReturn(listContacts);

		assertEquals("firstname1", PhoneBookServiceImpl.getContactBySurName("surname1").get(0).getFirstName());

	}

}
