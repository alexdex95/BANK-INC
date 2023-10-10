package com.credibanco.bank.inc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.bank.inc.repository.entity.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, String> {

	Iterable<Card> findAll();

}
