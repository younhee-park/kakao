package com.kko.service;

import java.io.File;
import java.util.List;

import com.kko.dto.HouseMoneyDto;
import com.kko.dto.HouseMoneyYearDto;
import com.kko.dto.InstituteDto;

public interface HouseMoneyService {
	
	/**
	 * 주택금융 공금협황 데이터 저장
	 * @param houseMoneyData
	 */
	void registHouseMoneyData(File houseMoneyData);
	
	/**
	 * 주택금융 공급기관 저장
	 * @param institutes
	 */
	void registBankData(List<InstituteDto> institutes);

	/**
	 * 주택금융 공급 금융기관(은행) 목력 가져오기
	 * @return
	 */
	List<String> getInstitueData();
	
	/**
	 * 년도별 각 금융기관의 지원금액 합계 가져오기
	 * @return
	 */
	HouseMoneyYearDto getHouseTotalAmountOfYear();
	
	/**
	 * 년도별 각 기관의 전체 지원금액 중 가장 큰 금액의 기관명 가져오기
	 * @param fromYear 시작년도
	 * @param toYear 끝년도
	 * @return
	 */
	HouseMoneyDto getInstituteOfLargestAmount(String fromYear, String toYear);
	
	/**
	 * 전체년도에서 외환은행 지원금액 평균 중에서 가장 작은 금액과 큰 금액 가져오기
	 * @return
	 */
	HouseMoneyDto getAvgAmoutOfMinAndMax();
	
}
