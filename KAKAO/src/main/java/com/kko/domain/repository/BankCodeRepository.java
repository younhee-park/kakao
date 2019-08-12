package com.kko.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kko.domain.model.BankEntity;

@Repository
public interface BankCodeRepository extends JpaRepository<BankEntity, String>{
	
}
