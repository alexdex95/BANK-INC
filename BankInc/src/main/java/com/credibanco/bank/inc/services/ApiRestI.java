package com.credibanco.bank.inc.services;

import com.credibanco.bank.inc.model.CardRequest;
import com.credibanco.bank.inc.model.CardResponse;
import com.credibanco.bank.inc.repository.entity.Card;
import com.credibanco.bank.inc.repository.entity.Transaction;

/**
 * @author Jefferson Alexander Moreno Barrera {@code public interface ApiRestI}
 */
public interface ApiRestI {

	CardResponse generateCardNumber(int productId);

	Card activateCard(String cardId);

	Card blockCard(long cardId);

	Card rechargeBalance(CardRequest body);

	CardResponse balanceInquiry(long cardId);

	Transaction purchaseTransaction(CardRequest body);

	Transaction consultTransaction(int transactionId);

	Transaction transactionCancelled(CardRequest body);
}
