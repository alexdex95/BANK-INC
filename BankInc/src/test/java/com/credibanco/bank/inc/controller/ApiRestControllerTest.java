package com.credibanco.bank.inc.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.credibanco.bank.inc.model.Request;
import com.credibanco.bank.inc.model.Response;
import com.credibanco.bank.inc.repository.entity.Transaction;
import com.credibanco.bank.inc.services.ApiRestImplement;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApiRestControllerTest {

	@InjectMocks
	ApiRestController controller;

	@Mock
	ApiRestImplement services;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
	}

	@Test
	void testCreateCard() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.createCard(request)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.createCard(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testGenerateCardNumber() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.generateCardNumber(1)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.generateCardNumber(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testActivateCard() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.activateCard("1000001616057078")).thenReturn(new Response());
		ResponseEntity<Response> response = controller.activateCard(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testBlockCard() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.blockCard(1)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.blockCard(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testRechargeBalance() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.rechargeBalance(request)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.rechargeBalance(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testBalanceInquiry() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.balanceInquiry(1)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.balanceInquiry(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testPurchaseTransaction() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.purchaseTransaction(request)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.purchaseTransaction(request);
		Assertions.assertNotNull(response);
	}

	@Test
	void testConsultTransaction() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.consultTransaction(1)).thenReturn(new Transaction());
		ResponseEntity<Transaction> response = controller.consultTransaction(1);
		Assertions.assertNotNull(response);
	}

	@Test
	void testTransactionCancelled() {
		Request request = new Request();
		request.setCardId("1000001616057078");
		request.setFirstName("prueba");
		when(services.transactionCancelled(request)).thenReturn(new Response());
		ResponseEntity<Response> response = controller.transactionCancelled(request);
		Assertions.assertNotNull(response);
	}

}
