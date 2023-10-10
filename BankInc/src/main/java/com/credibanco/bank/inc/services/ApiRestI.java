package com.credibanco.bank.inc.services;

/**
 * @author Jefferson Alexander Moreno Barrera {@code public interface ApiRestI}
 */
public interface ApiRestI {

	String getNumberCard();

	String postEnroll();

	String deleteCard();

	String postBalance();

	String getBalanceCard();

	String postPurchase();

	String getTransactionId();

	String postAnulation();
}
