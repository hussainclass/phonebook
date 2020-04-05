package com.ibm.phonebook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable{

	
	private static final long serialVersionUID = 8802961216335804652L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "surname")
	private String surName;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@Embedded
	private Address address = new Address();
	
	public Contact(){
		
	}

	public Contact(Long id, String surName, String firstName, String phoneNumber, Address address) {
		this.id = id;
		this.surName = surName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
