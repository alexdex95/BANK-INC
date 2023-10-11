package com.credibanco.bank.inc.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.bank.inc.model.Request;
import com.credibanco.bank.inc.model.Response;
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

	public Response createCard(Request body) {
		Response response = new Response();
		if (body.getCardId().length() > 16) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"el numero no contiene 16 dígitos:" + body.getCardId());
		}
		Optional<Card> cards = cardRepository.findById(body.getCardId());
		if (!cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"ya existe informacion en la tabla tajetas para el id: " + body.getCardId());
		} else {
			Card card = new Card();
			card.setIdTarjeta(Long.parseLong(body.getCardId()));
			card.setNombreTitular(body.getFirstName());
			card.setFechaCreacion(LocalDateTime.now());
			card.setFechaVencimiento(LocalDateTime.now().plusYears(3));
			card.setEstadoID(2);
			card.setProductoID(1);
			card.setSaldo(0);
			cardRepository.save(card);
			response.setMessage("TARJETA CREADA CON NUMERO:" + body.getCardId());
		}
		return response;
	}

	public Response generateCardNumber(int productId) {
		Optional<Product> products = productRepository.findById(String.valueOf(productId));
		if (products.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en la tabla productos para el id:" + productId);
		}
		Response response = new Response();
		response.setNumberCard(products.get().getNumeroProducto() + getRandom());
		return response;
	}

	private StringBuilder getRandom() {
		StringBuilder numberRamdon = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int digit = random.nextInt(10);
			numberRamdon.append(digit);
		}
		return numberRamdon;
	}

	public Response activateCard(String cardId) {
		Optional<Card> cards = cardRepository.findById(cardId);
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en la tabla tajetas para el id: " + cardId);
		} else
			cards.get().setEstadoID(1);
		cardRepository.save(cards.get());
		Response response = new Response();
		response.setMessage("TARJETA ACTIVADA");
		return response;
	}

	public Response blockCard(long cardId) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(cardId));
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en la tabla tajetas para el id:" + cardId);
		} else
			cards.get().setEstadoID(3);
		cardRepository.save(cards.get());
		Response response = new Response();
		response.setMessage("TARJETA BLOQUEADA");
		return response;
	}

	public Response rechargeBalance(Request request) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(request.getCardId()));
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + request.getCardId());
		}
		cards.get().setSaldo(cards.get().getSaldo() + Long.parseLong(request.getBalance()));
		cardRepository.save(cards.get());

		Recharge recharge = new Recharge();
		Optional<Recharge> recharges = rechargesRepository.findByTarjetId(cards.get().getIdTarjeta());
		if (recharges.isEmpty()) {
			recharge.setIdRecarga(0);
		} else {
			recharge.setIdRecarga(1);
		}
		recharge.setFechaRecarga(LocalDateTime.now());
		recharge.setValor(Long.parseLong(request.getBalance()));
		recharge.setTarjetaID(Long.parseLong(request.getCardId()));
		rechargesRepository.save(recharge);
		Response response = new Response();
		response.setMessage("RECARGA EXITOSA");
		return response;
	}

	public Response balanceInquiry(long cardId) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(cardId));
		Response cardResponse = new Response();
		cardResponse.setMessage("SU SALDO ES:" + cards.get().getSaldo());
		return cardResponse;
	}

	public Response purchaseTransaction(Request request) {
		if (!request.getCurrency().equalsIgnoreCase("USD")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "únicamente movimiento en dólares");
		}
		Optional<Card> cards = cardRepository.findById(String.valueOf(request.getCardId()));
		cards.get().setSaldo(cards.get().getSaldo() - request.getPrice());
		cardRepository.save(cards.get());

		Transaction transaction = new Transaction();
		transaction.setProductoID(cards.get().getProductoID());
		transaction.setFechaMovimiento(LocalDateTime.now());
		transaction.setValor(request.getPrice());
		transaction.setTarjetaID(cards.get().getIdTarjeta());
		transaction.setEstadoID(cards.get().getEstadoID());
		transactionRepository.save(transaction);
		Response response = new Response();
		response.setMessage("TRANSACION EXITOSA CON ID:" + transaction.getIdTransaccion());
		return response;
	}

	public Transaction consultTransaction(int transactionId) {
		Optional<Transaction> transaction = transactionRepository.findById(String.valueOf(transactionId));
		if (transaction.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en la tabla Transacciones para el id:" + transactionId);
		}
		return transaction.get();
	}

	public Response transactionCancelled(Request request) {
		Optional<Card> cards = cardRepository.findById(String.valueOf(request.getCardId()));
		if (cards.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en la tabla Tarjetas para el id:" + request.getCardId());
		}
		if (cards.get().getSaldo() <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no se puede realizar la transaccion el saldo de tarjeta es 0:" + request.getCardId());
		}
		Transaction transaction = consultTransaction(request.getTransactionId());
		if (validateHours(transaction.getFechaMovimiento())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"la transaccion supera las 24 horas:" + request.getCardId());
		}
		transaction.setEstadoID(4);
		transactionRepository.save(transaction);
		cards.get().setSaldo(cards.get().getSaldo() + transaction.getValor());
		cardRepository.save(cards.get());
		Response response = new Response();
		response.setMessage("TRANSACION ANULADA CON ID:" + transaction.getIdTransaccion());
		return response;
	}

	private boolean validateHours(LocalDateTime creationDate) {
		Duration duracion = Duration.between(creationDate, LocalDateTime.now());
		long horas = duracion.toHours();
		if (horas > 24) {
			return true;
		} else {
			return false;
		}
	}

}
