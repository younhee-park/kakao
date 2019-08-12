package com.kko.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.kko.dto.HouseMoneyDto;
import com.kko.dto.HouseMoneyYearDto;
import com.kko.dto.InstituteDto;
import com.kko.service.HouseMoneyService;



@RestController
public class HouseMoneyController {
	
	@Autowired
	HouseMoneyService houseMoneyService;
	
	private static final Logger logger = LoggerFactory.getLogger(HouseMoneyController.class);
	
    @PostMapping("/biz/house/registData")
    public ResponseEntity<String> uploadHouseMoneyData(@RequestPart MultipartFile dataFile) throws IOException {

    	String savePath = "C:\\yesbe";
    	
    	if (!dataFile.isEmpty()) {
    		
    		savePath = savePath + File.separator;
    		new File(savePath).mkdir();
	        File houseMoneyFile = new File(savePath+dataFile.getOriginalFilename());
	        
	        dataFile.transferTo(houseMoneyFile);
	        
	        houseMoneyService.registHouseMoneyData(houseMoneyFile);
    	}

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
    
    @PutMapping("/biz/house/registBanks")
    public ResponseEntity<?> registBanks() {

	    List<InstituteDto> institutes = Lists.newArrayList();  
	    InstituteDto institute = new InstituteDto();
	    institute.setInstitueCode("000");
	    institute.setInstituteName("주택도시기금");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("004");
	    institute.setInstituteName("국민은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("020");
	    institute.setInstituteName("우리은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("088");
	    institute.setInstituteName("신한은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("027");
	    institute.setInstituteName("한국시티은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("081");
	    institute.setInstituteName("하나은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("011");
	    institute.setInstituteName("농협/수협은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("005");
	    institute.setInstituteName("외환은행");
	    institutes.add(institute);
	    institute = new InstituteDto();
	    institute.setInstitueCode("999");
	    institute.setInstituteName("기타은행");
	    institutes.add(institute);	    
	        
        houseMoneyService.registBankData(institutes);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
	
    
	@GetMapping("/biz/house/getInstituteList")
	public ResponseEntity<List<String>> getInstitute() {

		List<String> result = houseMoneyService.getInstitueData();

		if(result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
//	
//	@GetMapping("/biz/house/getHouseTotalAmountOfYear")
//	public ResponseEntity<List<HouseMoneyDto>> getHouseTotalAmountOfYear() {
//
//		List<HouseMoneyDto> result = houseMoneyService.getHouseTotalAmountOfYear();
//
//		if(result == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		}
//	}
	
	@GetMapping("/biz/house/getHouseTotalAmountOfYear")
	public ResponseEntity<HouseMoneyYearDto> getHouseTotalAmountOfYear() {

		HouseMoneyYearDto result = houseMoneyService.getHouseTotalAmountOfYear();

		if(result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping("/biz/house/instituteOfMaxAmount")
	public ResponseEntity<HouseMoneyDto> getInstituteOfMaxAmount(
			@RequestParam(name="fromYear", defaultValue="2005") @Min(2005) String fromYear,
			@RequestParam(name="toYear", defaultValue="2017") @Max(2017) String toYear) {

		HouseMoneyDto result = houseMoneyService.getInstituteOfLargestAmount(fromYear, toYear);

		if(result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping("/biz/house/instituteOfAvgAmount")
	public ResponseEntity<HouseMoneyDto> getInstituteOfAvgAmount() {

		HouseMoneyDto result = houseMoneyService.getAvgAmoutOfMinAndMax();

		if(result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
}
