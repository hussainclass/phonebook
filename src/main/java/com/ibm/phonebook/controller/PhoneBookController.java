package com.ibm.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.phonebook.entity.Contact;
import com.ibm.phonebook.exception.RecordNotFoundException;
import com.ibm.phonebook.service.PhoneBookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/phonebook/")
public class PhoneBookController {

	@Autowired
	private PhoneBookService service;

	@ApiOperation(value = "get phonebook contact details for given  surname", tags = "phonebook_entries_by_surname")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(path = "/contacts/{surname}", produces = "application/json")
	public ResponseEntity<List<Contact>> getContactDetails(@PathVariable("surname") String surname) {

		List<Contact> lstContact = null;

		try {
			lstContact = service.getContactBySurName(surname);
			if (lstContact == null) {
				return new ResponseEntity<List<Contact>>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}

		} catch (RecordNotFoundException e) {

			e.printStackTrace();
		}
		return new ResponseEntity<List<Contact>>(lstContact, new HttpHeaders(), HttpStatus.OK);
	}

	@ApiOperation(value = "update phone book contact entry", tags = "update_phonebook_entry")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PutMapping(path = "/contacts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Contact> updatePhoneBookEntry(@RequestBody Contact contact) {

		Contact dbContact = service.createOrUpdateContact(contact);
		return new ResponseEntity<Contact>(dbContact, new HttpHeaders(), HttpStatus.OK);

	}

	@ApiOperation(value = "create phone book contact entry", tags = "create_phonebook_entry")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(path = "/contacts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Contact> createPhoneBookEntry(@RequestBody Contact contact) {

		Contact dbContact = service.createOrUpdateContact(contact);
		return new ResponseEntity<Contact>(dbContact, new HttpHeaders(), HttpStatus.OK);

	}

	@ApiOperation(value = "get all phone book contact entries", tags = "get_all_phonebook_entries")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(path = "/contacts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllPhoneBookEntries() {

		List<Contact> lstContacts = service.getAllContacts();
		return new ResponseEntity<List<Contact>>(lstContacts, new HttpHeaders(), HttpStatus.OK);

	}

	@ApiOperation(value = "delete phone book contact entry", tags = "delete_phonebook_entry")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@DeleteMapping(path = "/contacts/{id}", produces = "text/plain")
	public ResponseEntity<String> deletePhoneBookEntry(@PathVariable("id") Long id) throws RecordNotFoundException {

		service.deleteContactById(id);
		return new ResponseEntity<String>("PhoneBook Entry " + id +" Deleted Successfully ", new HttpHeaders(), HttpStatus.OK);

	}
}