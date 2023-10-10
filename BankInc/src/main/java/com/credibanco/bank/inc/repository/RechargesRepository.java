package com.credibanco.bank.inc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.bank.inc.repository.entity.Recharge;

@Repository
public interface RechargesRepository extends CrudRepository<Recharge, String> {

}
