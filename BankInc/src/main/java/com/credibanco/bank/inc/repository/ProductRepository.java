package com.credibanco.bank.inc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.bank.inc.repository.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}
