package com.kko.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kko.domain.model.HouseMoneyEntity;
import com.kko.domain.model.HouseMoneyOfBankNm;

@Repository
public interface HouseMoneyRepository extends CrudRepository<HouseMoneyEntity, String>, JpaSpecificationExecutor<HouseMoneyEntity> {

//	List<HouseMoneyEntity> findAll(Specification<HouseMoneyEntity> spec);
	
	@Transactional(readOnly = true)
	@Query("SELECT e.suptYear AS suptYear, e.instituteCode As instituteCode, b.instituteName As instituteName, SUM(e.amount) as amount"
			+ " FROM BankEntity b JOIN HouseMoneyEntity e"
			+ " ON b.instituteCode = e.instituteCode"
			+ " GROUP BY e.suptYear , e.instituteCode"
			+ " ORDER BY e.suptYear , e.instituteCode asc")	
	List<HouseMoneyOfBankNm> findHouseTotalAmountBy();
	
	@Transactional(readOnly = true)
	@Query("SELECT e.suptYear AS suptYear, b.instituteName As instituteName"
			+ " FROM BankEntity b JOIN HouseMoneyEntity e"
			+ " ON b.instituteCode = e.instituteCode"
			+ " WHERE"
			+ " e.amount IN ("
			+ " SELECT MAX(amount) as amount "
			+ " FROM HouseMoneyEntity "
			+ " WHERE "
			+ "	suptYear >= :fromYear AND suptYear <=:toYear"
			+ " )")
	HouseMoneyOfBankNm findHouseMaxAmountBy(@Param("fromYear") String fromYear, @Param("toYear") String toYear);
	
	@Transactional(readOnly = true)
	@Query("SELECT e.suptYear AS suptYear, b.instituteName As instituteName,"
			+ " SUM(e.amount) AS amount"
			+ " FROM BankEntity b JOIN HouseMoneyEntity e"
			+ " ON b.instituteCode = e.instituteCode"
			+ " WHERE"
			+ " e.instituteCode='005'"
			+ " AND e.suptYear < 2017"
			+ " GROUP BY e.suptYear"
			+ " ORDER BY e.suptYear ASC") 
	
	List<HouseMoneyOfBankNm> findHouseAvgAmountBy();
}
