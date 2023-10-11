package com.credibanco.bank.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.bank.inc.model.Request;
import com.credibanco.bank.inc.model.Response;
import com.credibanco.bank.inc.repository.entity.Transaction;
import com.credibanco.bank.inc.services.ApiRestImplement;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestController}
 */

@RestController
@RequestMapping(path = "/V1/API/")
public class ApiRestController {

	@Autowired
	ApiRestImplement apiRestImplement;

	@PostMapping("card/create")
	public ResponseEntity<Response> createCard(@RequestBody Request body) {
		return new ResponseEntity<>(apiRestImplement.createCard(body), HttpStatus.OK);
	}

	@GetMapping("card/{productId}/number")
	public ResponseEntity<Response> generateCardNumber(@PathVariable("productId") int productId) {
		return new ResponseEntity<>(apiRestImplement.generateCardNumber(productId), HttpStatus.OK);
	}

	@PostMapping("card/enroll")
	public ResponseEntity<Response> activateCard(@RequestBody Request body) {
		return new ResponseEntity<>(apiRestImplement.activateCard(body.getCardId()), HttpStatus.OK);
	}

	@DeleteMapping("card/{cardId}")
	public ResponseEntity<Response> blockCard(@PathVariable("cardId") long cardId) {
		return new ResponseEntity<>(apiRestImplement.blockCard(cardId), HttpStatus.OK);
	}

	@PostMapping("card/balance")
	public ResponseEntity<Response> rechargeBalance(@RequestBody Request body) {
		return new ResponseEntity<>(apiRestImplement.rechargeBalance(body), HttpStatus.OK);
	}

	@GetMapping("card/balance/{cardId}")
	public ResponseEntity<Response> balanceInquiry(@PathVariable("cardId") long cardId) {
		return new ResponseEntity<>(apiRestImplement.balanceInquiry(cardId), HttpStatus.OK);
	}

	@PostMapping("transaction/purchase")
	public ResponseEntity<Response> purchaseTransaction(@RequestBody Request body) {
		return new ResponseEntity<>(apiRestImplement.purchaseTransaction(body), HttpStatus.OK);
	}

	@GetMapping("transaction/{transactionId}")
	public ResponseEntity<Transaction> consultTransaction(@PathVariable("transactionId") int transactionId) {
		return new ResponseEntity<>(apiRestImplement.consultTransaction(transactionId), HttpStatus.OK);
	}

	@PostMapping("transaction/anulation")
	public ResponseEntity<Response> transactionCancelled(@RequestBody Request body) {
		return new ResponseEntity<>(apiRestImplement.transactionCancelled(body), HttpStatus.OK);
	}

}
