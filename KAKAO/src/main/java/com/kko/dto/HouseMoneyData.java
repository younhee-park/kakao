package com.kko.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.collect.Lists;

public class HouseMoneyData {

	@NotNull 
	private String suptYear;
	@NotNull @Size(min=1, max=12)
	private Integer suptMonth;
	private Integer totAmount;
	@NotNull
	private List<HouseMoneyDetailData> houseMoneyDetails = Lists.newArrayList();
	
	public String getSuptYear() {
		return suptYear;
	}
	public void setSuptYear(String suptYear) {
		this.suptYear = suptYear;
	}
	public Integer getSuptMonth() {
		return suptMonth;
	}
	public void setSuptMonth(Integer suptMonth) {
		this.suptMonth = suptMonth;
	}
	
	public Integer getTotAmount() {
		return totAmount;
	}
	public void setTotAmount(Integer totAmount) {
		this.totAmount = totAmount;
	}
	public List<HouseMoneyDetailData> getHouseMoneyDetails() {
		return houseMoneyDetails;
	}
	public void setHouseMoneyDetails(List<HouseMoneyDetailData> houseMoneyDetails) {
		this.houseMoneyDetails = houseMoneyDetails;
	}
	@Override
	public String toString() {
		return "HouseMoneyData [suptYear=" + suptYear + ", suptMonth=" + suptMonth + ", totAmount=" + totAmount
				+ ", houseMoneyDetails=" + houseMoneyDetails + "]";
	}
}
