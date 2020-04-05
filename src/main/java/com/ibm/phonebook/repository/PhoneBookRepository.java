package com.ibm.phonebook.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.phonebook.entity.Contact;

@Repository
@Transactional
public interface PhoneBookRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findBySurName(String surName);

}
