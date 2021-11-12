package com.bibhu.eazybank.controller;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.eazybank.model.Contact;
import com.bibhu.eazybank.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@PostMapping("/contact")
	//@PreFilter("filterObject.contactName == 'Test'")
	@PostFilter("filterObject.contactName == 'Test'")
	public Contact saveContactInquiryDetails(@RequestBody final Contact contact) {
		contact.setContactId(this.getServiceReqNumber());
		contact.setCreateDt(new Date(System.currentTimeMillis()));
		return this.contactRepository.save(contact);
	}

	public String getServiceReqNumber() {
		final Random random = new Random();
		final int ranNum = random.nextInt(999999999 - 9999) + 9999;
		return "SR"+ranNum;
	}

}
