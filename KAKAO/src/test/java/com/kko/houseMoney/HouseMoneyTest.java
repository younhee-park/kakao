package com.kko.houseMoney;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kko.domain.model.HouseMoneyOfBankNm;
import com.kko.domain.repository.HouseMoneyRepository;
import com.kko.dto.HouseMoneyYearDto;
import com.kko.service.HouseMoneyService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest	
public class HouseMoneyTest {

	@Autowired
	HouseMoneyService houseMoneyService;
	
	@Autowired
	HouseMoneyRepository houseMoneyRepository;
	
	@Test
	public void getHouseTotalAmountOfYear() {
		HouseMoneyYearDto houseMoneyYearDto = houseMoneyService.getHouseTotalAmountOfYear();
		Integer totAmount = houseMoneyYearDto.getHouseMoneys().get(0).getTotalAmount();
		
		List<String> instituteNames= houseMoneyService.getInstitueData();
		
		Map<String,Integer> dtAmount = houseMoneyYearDto.getHouseMoneys().get(0).getDetailAmouts();
	    int dtSum = dtAmount.values().stream().mapToInt(i->i).sum();
		
	    assert (totAmount.equals(dtSum));
		
	}
	
	@Test
	public void getHouseMaxAmount() {
		HouseMoneyOfBankNm houseMoney = houseMoneyRepository.findHouseMaxAmountBy("2004", "2017");
		
		 assert (houseMoney.getSuptYear().isEmpty());
		 assert (houseMoney.getAmount() > 0 );
	}
}
