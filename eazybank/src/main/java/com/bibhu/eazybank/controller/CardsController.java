package com.bibhu.eazybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.eazybank.model.Cards;
import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.repository.CardsRepository;

@RestController
public class CardsController {

	@Autowired
	private CardsRepository cardsRepository;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody final Customer customer) {
		final List<Cards> cards = this.cardsRepository.findByCustomerId(customer.getId());
		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}

}
