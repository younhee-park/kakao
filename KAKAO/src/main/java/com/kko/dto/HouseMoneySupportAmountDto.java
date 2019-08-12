package com.kko.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class HouseMoneySupportAmountDto {
	
	@JsonProperty("year")
	private String suptYear;
	private Integer amount;
	@JsonIgnore
	private Double avgAmount;

	public String getSuptYear() {
		return suptYear;
	}

	public void setSuptYear(String suptYear) {
		this.suptYear = suptYear;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getAvgAmount() {
		return avgAmount;
	}

	public void setAvgAmount(Double avgAmount) {
		this.avgAmount = avgAmount;
	}

	@Override
	public String toString() {
		return "HouseMoneySupportAmountDto [suptYear=" + suptYear + ", amount=" + amount + ", avgAmount=" + avgAmount
				+ "]";
	}
	
}
