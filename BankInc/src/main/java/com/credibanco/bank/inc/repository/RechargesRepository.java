package com.credibanco.bank.inc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.bank.inc.repository.entity.Recharge;

@Repository
public interface RechargesRepository extends CrudRepository<Recharge, String> {

	@Query(value = "SELECT * from RECARGAS WHERE TARJETAID=:id", nativeQuery = true)
	Optional<Recharge> findByTarjetId(long id);

}
