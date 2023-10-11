package com.credibanco.bank.inc.services;

import com.credibanco.bank.inc.model.Request;
import com.credibanco.bank.inc.model.Response;
import com.credibanco.bank.inc.repository.entity.Transaction;

/**
 * @author Jefferson Alexander Moreno Barrera {@code public interface ApiRestI}
 */
public interface ApiRestI {

	Response createCard(Request body);

	Response generateCardNumber(int productId);

	Response activateCard(String cardId);

	Response blockCard(long cardId);

	Response rechargeBalance(Request body);

	Response balanceInquiry(long cardId);

	Response purchaseTransaction(Request body);

	Transaction consultTransaction(int transactionId);

	Response transactionCancelled(Request body);
}
