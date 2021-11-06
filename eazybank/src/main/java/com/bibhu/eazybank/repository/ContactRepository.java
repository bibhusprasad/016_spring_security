package com.bibhu.eazybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibhu.eazybank.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
