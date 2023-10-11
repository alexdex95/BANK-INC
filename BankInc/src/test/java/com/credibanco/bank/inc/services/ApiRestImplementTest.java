package com.credibanco.bank.inc.services;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApiRestImplementTest {

	@Mock
	CardRepository cardRepository;

	@Mock
	ProductRepository productRepository;

	@Mock
	TransactionRepository transactionRepository;

	@Mock
	RechargesRepository rechargesRepository;

	@InjectMocks
	ApiRestImplement services;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateCard() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		Optional<Card> cards = Optional.empty();
		when(cardRepository.findById(anyString())).thenReturn(cards);
		Response response = services.createCard(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testGenerateCardNumber() {
		Product product = new Product();
		product.setNumeroProducto("100000");
		Optional<Product> products = Optional.of(product);
		when(productRepository.findById(anyString())).thenReturn(products);
		Response response = services.generateCardNumber(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testActivateCard() {
		Card card = new Card();
		Optional<Card> cards = Optional.of(card);
		when(cardRepository.findById(anyString())).thenReturn(cards);
		Response response = services.activateCard("1");
		Assertions.assertNotNull(response);
	}

	@Test
	void testBlockCard() {
		Card card = new Card();
		Optional<Card> cards = Optional.of(card);
		when(cardRepository.findById(anyString())).thenReturn(cards);
		Response response = services.blockCard(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testRechargeBalance() {
		Card card = new Card();
		card.setSaldo(1000);
		card.setIdTarjeta(123);
		Optional<Card> cards = Optional.of(card);
		when(cardRepository.findById(anyString())).thenReturn(cards);

		Recharge recharge = new Recharge();
		Optional<Recharge> recharges = Optional.of(recharge);
		when(rechargesRepository.findByTarjetId(123)).thenReturn(recharges);

		Request request = new Request();
		request.setCardId("1000001616057078");

		request.setBalance("1000");
		Response response = services.rechargeBalance(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testBalanceInquiry() {
		Card card = new Card();
		Optional<Card> cards = Optional.of(card);
		when(cardRepository.findById(anyString())).thenReturn(cards);
		Response response = services.balanceInquiry(1);
		Assertions.assertNotNull(response);
	}
/*
	@Test
	void testPurchaseTransaction() {

	}

	@Test
	void testConsultTransaction() {

	}

	@Test
	void testTransactionCancelled() {

	}
*/
}
