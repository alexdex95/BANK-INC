package com.credibanco.bank.inc.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.bank.inc.repository.CardRepository;
import com.credibanco.bank.inc.repository.ProductRepository;
import com.credibanco.bank.inc.repository.entity.Product;

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

	public String getNumberCard(int productId) {
		Optional<Product> products = productRepository.findById(String.valueOf(productId));
		if (products.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + productId);
		}
		return products.get().getNumeroProducto() + getRandom();
	}

	public StringBuilder getRandom() {
		StringBuilder numeroAleatorio = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int digito = random.nextInt(10);
			numeroAleatorio.append(digito);
		}
		return numeroAleatorio;
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
