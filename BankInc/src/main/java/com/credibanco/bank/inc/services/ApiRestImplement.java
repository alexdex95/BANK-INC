package com.credibanco.bank.inc.services;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.bank.inc.model.CardRequest;
import com.credibanco.bank.inc.model.CardResponse;
import com.credibanco.bank.inc.repository.CardRepository;
import com.credibanco.bank.inc.repository.ProductRepository;
import com.credibanco.bank.inc.repository.RechargesRepository;
import com.credibanco.bank.inc.repository.TransactionRepository;
import com.credibanco.bank.inc.repository.entity.Card;
import com.credibanco.bank.inc.repository.entity.Product;
import com.credibanco.bank.inc.repository.entity.Recharge;
import com.credibanco.bank.inc.repository.entity.Transaction;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestImplement}
 */
@Service
public class ApiRestImplement implements ApiRestI {

	@Autowired
	CardRepository cardRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	RechargesRepository rechargesRepository;

	@Autowired
	public ApiRestImplement(RechargesRepository rechargesRepository) {
		this.rechargesRepository = rechargesRepository;
	}

	public CardResponse generateCardNumber(int productId) {
		Optional<Product> products = productRepository.findById(String.valueOf(productId));
		if (products.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + productId);
		}
		CardResponse cardResponse = new CardResponse();
		cardResponse.setNumberCard(products.get().getNumeroProducto() + getRandom());
		return cardResponse;
	}

	private StringBuilder getRandom() {
		StringBuilder numeroAleatorio = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int digito = random.nextInt(10);
			numeroAleatorio.append(digito);
		}
		return numeroAleatorio;
	}

	public Card activateCard(String cardId) {
		Optional<Card> cards = cardRepository.findById(cardId);
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + cardId);
		} else
			cards.get().setEstadoID(1);
		cardRepository.save(cards.get());
		return cardRepository.findById(cardId).get();
	}

	public Card blockCard(long cardId) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(cardId));
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + cardId);
		} else
			cards.get().setEstadoID(3);
		cardRepository.save(cards.get());
		return cards.get();
	}

	public Card rechargeBalance(CardRequest body) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(body.getCardId()));
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + body.getCardId());
		} else
			cards.get().setSaldo(cards.get().getSaldo() + Long.parseLong(body.getBalance()));
		cardRepository.save(cards.get());
		Recharge recharge = new Recharge();
		recharge.setFechaRecarga(LocalDate.now());
		recharge.setValor(Long.parseLong(body.getBalance()));
		recharge.setTarjetaID(Long.parseLong(body.getCardId()));
		rechargesRepository.save(recharge);
		return cards.get();
	}

	public CardResponse balanceInquiry(long cardId) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(cardId));
		CardResponse cardResponse = new CardResponse();
		cardResponse.setBalance(cards.get().getSaldo());
		return cardResponse;
	}

	public Transaction purchaseTransaction(CardRequest body) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(body.getCardId()));
		cards.get().setSaldo(cards.get().getSaldo()-body.getPrice());
		cardRepository.save(cards.get());
		
		Transaction transaction = new Transaction();
		transaction.setProductoID(cards.get().getProductoID());
		transaction.setFechaMovimiento(LocalDate.now());
		transaction.setValor(body.getPrice());
		transaction.setTarjetaID(cards.get().getIdTarjeta());
		transaction.setEstadoID(cards.get().getEstadoID());
		transactionRepository.save(transaction);
		
		return transaction;
	}

	public Transaction consultTransaction(int transactionId) {
		Optional<Transaction> transaction = transactionRepository.findById(String.valueOf(transactionId));
		return transaction.get();
	}

	public Transaction transactionCancelled(CardRequest body) {
		Optional<Transaction> transaction = transactionRepository.findById(String.valueOf(body.getTransactionId()));
		transaction.get().setEstadoID(4);
		Optional<Card> cards = cardRepository.findById(String.valueOf(body.getCardId()));
		cards.get().setSaldo(cards.get().getSaldo()+transaction.get().getValor());
		cardRepository.save(cards.get());
		return transaction.get();
	}
}
