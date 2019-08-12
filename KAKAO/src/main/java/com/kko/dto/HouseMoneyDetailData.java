package com.kko.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public class HouseMoneyDetailData {

	private String instituteCode;
	private String instituteName;
	private Integer amount;
	
	public String getInstituteCode() {
		return instituteCode;
	}
	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}
	@JsonValue
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	@JsonValue
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "HouseMoneyDetailData [instituteCode=" + instituteCode + ", instituteName=" + instituteName + ", amount="
				+ amount + "]";
	}
	
}
