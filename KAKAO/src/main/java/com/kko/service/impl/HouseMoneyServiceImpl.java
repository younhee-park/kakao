package com.kko.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kko.domain.model.BankEntity;
import com.kko.domain.model.HouseMoneyEntity;
import com.kko.domain.model.HouseMoneyOfBankNm;
import com.kko.domain.repository.BankCodeRepository;
import com.kko.domain.repository.HouseMoneyRepository;
import com.kko.dto.HouseMoneyData;
import com.kko.dto.HouseMoneyDetailData;
import com.kko.dto.HouseMoneyDto;
import com.kko.dto.HouseMoneySupportAmountDto;
import com.kko.dto.HouseMoneyYearDto;
import com.kko.dto.InstituteDto;
import com.kko.service.HouseMoneyException;
import com.kko.service.HouseMoneyService;

@Service
public class HouseMoneyServiceImpl implements HouseMoneyService{
	
	@Autowired
	HouseMoneyRepository houseMoneyRespository;
	
	@Autowired
	BankCodeRepository bankCodeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(HouseMoneyServiceImpl.class);

	@Override
	public void registHouseMoneyData(File houseMoneyFile) {

		List<HouseMoneyData> houseMoneys = Lists.newArrayList();
		
		try {
			String data = null;
			
			BufferedReader in = new BufferedReader(new FileReader(houseMoneyFile));
			int row = 0;
			while( (data = in.readLine()) != null) {
				if (row > 0) {
					String[] tokens = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					
					if (tokens.length > 1) {
					
					List<HouseMoneyDetailData> detailDatas = Lists.newArrayList();
					HouseMoneyData houseMoneyData = new HouseMoneyData();
					
						int i = 0;
						for (String token : tokens) {
							if (i == 0) houseMoneyData.setSuptYear(token);
							else if (i == 1) houseMoneyData.setSuptMonth(Integer.valueOf(token));
							else if (i == 2) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("000");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 3) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("004");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 4) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("020");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 5) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("088");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 6) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("027");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 7) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("081");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 8) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("011");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 9) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("005");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}else if (i == 10) { 
								HouseMoneyDetailData detailData = new HouseMoneyDetailData();
								detailData.setInstituteCode("999");
								detailData.setAmount(Integer.valueOf(token.contains(",") ? token.replace(",", "").replace("\"", "") : token));
								detailDatas.add(detailData);
							}
							i++;
						}
						houseMoneyData.setHouseMoneyDetails(detailDatas);
						if (!houseMoneyData.getHouseMoneyDetails().isEmpty())
							houseMoneys.add(houseMoneyData);
					}
				}
				row ++;
			}
			
			in.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		houseMoneys.stream().forEach(p->{
			if (p.getHouseMoneyDetails() != null && !p.getHouseMoneyDetails().isEmpty()) {
				
				p.getHouseMoneyDetails().stream().forEach(pp ->{
					HouseMoneyEntity houseMoneyEntity = new HouseMoneyEntity();
					houseMoneyEntity.setSuptYear(p.getSuptYear());
					houseMoneyEntity.setSuptMonth(p.getSuptMonth());
					
					houseMoneyEntity.setInstituteCode(pp.getInstituteCode());
					houseMoneyEntity.setAmount(pp.getAmount());
				
					houseMoneyRespository.save(houseMoneyEntity);
				});
			}
		});
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<String> getInstitueData() {
		
		List<BankEntity> bankEntitys = bankCodeRepository.findAll();
		List<String> banks = bankEntitys.stream().map(BankEntity::getInstituteName).collect(Collectors.toList());
		
		return banks;
	}

	@Transactional(readOnly = true)
	@Override
	public HouseMoneyYearDto getHouseTotalAmountOfYear() {
		logger.info("getHouseTotalAmountOfYear");
		
        List<HouseMoneyOfBankNm> houseMoneys = houseMoneyRespository.findHouseTotalAmountBy();
        if (houseMoneys == null) {
        	logger.info("Data is not found");
            return null;
        } 
        
        HouseMoneyYearDto houseMoneyYearDto = new HouseMoneyYearDto();
        List<HouseMoneyDto> houseMoneyDtos = Lists.newArrayList();
        Map<String, Integer> detailDatas = Maps.newHashMap();
        int totalAmount =0;
        String curYear = houseMoneys.get(0).getSuptYear();
        int i=0;
        
        for (HouseMoneyOfBankNm hm : houseMoneys) {
        	System.out.println(hm.getSuptYear()+","+hm.getInstituteName()+","+hm.getAmount());
        	
//           	HouseMoneyDetailDto detailData = new HouseMoneyDetailDto(hm.getInstituteName(), hm.getAmount());
        	detailDatas.put(hm.getInstituteName(),hm.getAmount());
        	
           	if (!hm.getSuptYear().equals(curYear) || i == houseMoneys.size()-1){
        		HouseMoneyDto houseMoneyDto = new HouseMoneyDto();
        		
        		houseMoneyDto.setSuptYear(curYear +"년");
        		houseMoneyDto.setTotalAmount(totalAmount);
        		houseMoneyDto.setDetailAmouts(detailDatas);
        		houseMoneyDtos.add(houseMoneyDto);
        		
        		detailDatas = null;
        		detailDatas = Maps.newHashMap();
        		totalAmount = 0;
        	}
           	
    		totalAmount = totalAmount + hm.getAmount();
        	System.out.println("total ="+ totalAmount);
        	
        	curYear = hm.getSuptYear();
        	
        	i++;
        }
        
        houseMoneyYearDto.setHouseMoneys(houseMoneyDtos);
        
	    return houseMoneyYearDto;
	}
	
	@Transactional(readOnly = true)
	@Override
	public HouseMoneyDto getInstituteOfLargestAmount(String fromYear, String toYear) {
		logger.info("getInstituteOfLargestAmount");
		
        HouseMoneyOfBankNm houseMoney = houseMoneyRespository.findHouseMaxAmountBy(fromYear, toYear);
        if (houseMoney == null) {
        	logger.info("Data is not found");
            return null;
        } 
        
        HouseMoneyDto houseMoneyDto = new HouseMoneyDto();
        houseMoneyDto.setSuptYear(houseMoney.getSuptYear());
        houseMoneyDto.setInstituteName(houseMoney.getInstituteName());
        
		return houseMoneyDto;
	}

	@Transactional(readOnly = true)
	@Override
	public HouseMoneyDto getAvgAmoutOfMinAndMax() {
		logger.info("getAvgAmoutOfMinAndMax");
		
        List<HouseMoneyOfBankNm> houseMoneys = houseMoneyRespository.findHouseAvgAmountBy();
        if (houseMoneys == null) {
        	logger.info("Data is not found");
            return null;
        } 
        
        HouseMoneyDto houseMoneyDto = new HouseMoneyDto();
        List<HouseMoneySupportAmountDto> supportAmounts = Lists.newArrayList();
        
        houseMoneyDto.setInstituteName(houseMoneys.get(0).getInstituteName());
        for (HouseMoneyOfBankNm hm : houseMoneys) {
        	HouseMoneySupportAmountDto supportAmount = new HouseMoneySupportAmountDto();
        	supportAmount.setSuptYear(hm.getSuptYear());
        	supportAmount.setAvgAmount(Double.valueOf(hm.getAmount()) / 12);
        	supportAmount.setAmount((int)Math.round(supportAmount.getAvgAmount()));
        	supportAmounts.add(supportAmount);
        }
        HouseMoneyDto result = new HouseMoneyDto();
        HouseMoneySupportAmountDto maxData=  supportAmounts.stream().max(Comparator.comparing(HouseMoneySupportAmountDto::getAmount))
        .orElseThrow(NoSuchElementException::new);
        
        HouseMoneySupportAmountDto minData=  supportAmounts.stream().min(Comparator.comparing(HouseMoneySupportAmountDto::getAmount))
        .orElseThrow(NoSuchElementException::new);
        
        result.setInstituteName(houseMoneyDto.getInstituteName());
        List<HouseMoneySupportAmountDto> resultDatas = Lists.newArrayList();
        resultDatas.add(minData);
        resultDatas.add(maxData);
        
        result.setSupportAmouts(resultDatas);

		return result;
	}

	@Transactional
	@Override
	public void registBankData(List<InstituteDto> institutes) {
		// TODO Auto-generated method stub
		if (institutes == null)
			throw new HouseMoneyException("Data is not found.");
		
		if (institutes != null && !institutes.isEmpty()) {
			institutes.stream().forEach(p->{
				BankEntity bankEntity = new BankEntity();
				bankEntity.setInstituteCode(p.getInstitueCode());
				bankEntity.setInstituteName(p.getInstituteName());
				bankCodeRepository.saveAndFlush(bankEntity);
			});
		}
	}
}
