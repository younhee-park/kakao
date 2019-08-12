package com.kko.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class HouseMoneyDto {

	@JsonProperty("year")
	private String suptYear;
	
	@JsonProperty("total_amount")
	private Integer totalAmount;

	@JsonProperty("bank")
	private String instituteName;
	
	@JsonProperty("detail_amount")
	private Map<String, Integer> detailAmouts;
	
	@JsonProperty("support_amount")
	private List<HouseMoneySupportAmountDto> supportAmouts = null;
	
	
	public String getSuptYear() {
		return suptYear;
	}

	public void setSuptYear(String suptYear) {
		this.suptYear = suptYear;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<HouseMoneySupportAmountDto> getSupportAmouts() {
		return supportAmouts;
	}

	public Map<String, Integer> getDetailAmouts() {
		return detailAmouts;
	}

	public void setDetailAmouts(Map<String, Integer> detailAmouts) {
		this.detailAmouts = detailAmouts;
	}

	public void setSupportAmouts(List<HouseMoneySupportAmountDto> supportAmouts) {
		this.supportAmouts = supportAmouts;
	}
	
	@Override
	public String toString() {
		return "HouseMoneyDto [suptYear=" + suptYear + ", totalAmount=" + totalAmount + ", instituteName="
				+ instituteName + ", detailAmouts=" + detailAmouts + ", supportAmouts=" + supportAmouts + "]";
	}

}
