package com.credibanco.bank.inc.services;

import org.springframework.stereotype.Service;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestImplement}
 */
@Service
public class ApiRestImplement implements ApiRestI {

	public String getNumberCard() {
		return "getNumberCard";
	}

	public String postEnroll() {
		return "postEnroll";
	}

	public String deleteCard() {
		return "deleteCard";
	}

	public String postBalance() {
		return "postBalance";
	}

	public String getBalanceCard() {
		return "getBalanceCard";
	}

	public String postPurchase() {
		return "postPurchase";
	}

	public String getTransactionId() {
		return "getTransactionId";
	}

	public String postAnulation() {
		return "postAnulation";
	}
}
