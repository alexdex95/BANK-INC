package com.credibanco.bank.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("card/{productId}/number")
	public ResponseEntity<String> getNumberCard(@PathVariable("productId") int productId) {
		return new ResponseEntity<>(apiRestImplement.getNumberCard(productId), HttpStatus.OK);
	}

	@PostMapping("card/enroll")
	public ResponseEntity<String> postEnroll() {
		return new ResponseEntity<>(apiRestImplement.postEnroll(), HttpStatus.OK);
	}

	@DeleteMapping("card/{cardId}")
	public ResponseEntity<String> deleteCard() {
		return new ResponseEntity<>(apiRestImplement.deleteCard(), HttpStatus.OK);
	}

	@PostMapping("card/balance")
	public ResponseEntity<String> postBalance() {
		return new ResponseEntity<>(apiRestImplement.postBalance(), HttpStatus.OK);
	}

	@GetMapping("card/balance/{cardId}")
	public ResponseEntity<String> getBalanceCard() {
		return new ResponseEntity<>(apiRestImplement.getBalanceCard(), HttpStatus.OK);
	}

	@PostMapping("transaction/purchase")
	public ResponseEntity<String> postPurchase() {
		return new ResponseEntity<>(apiRestImplement.postPurchase(), HttpStatus.OK);
	}

	@GetMapping("transaction/{transactionId}")
	public ResponseEntity<String> getTransactionId() {
		return new ResponseEntity<>(apiRestImplement.getTransactionId(), HttpStatus.OK);
	}

	@PostMapping("transaction/anulation")
	public ResponseEntity<String> postAnulation() {
		return new ResponseEntity<>(apiRestImplement.postAnulation(), HttpStatus.OK);
	}

}
