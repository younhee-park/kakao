package com.kko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HouseMoneyDetailDto {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("year")
	private Integer suptYear;
	
	@JsonProperty("month")
	private Integer suptMonth;
	
	@JsonProperty("bank")
	private String instituteCode;
	
	private String instituteName;
	
	private Integer amount;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HouseMoneyDetailDto(String instituteName, Integer amount) {
		super();
		this.instituteName = instituteName;
		this.amount = amount;
	}

	public Integer getSuptYear() {
		return suptYear;
	}

	public void setSuptYear(Integer suptYear) {
		this.suptYear = suptYear;
	}

	public Integer getSuptMonth() {
		return suptMonth;
	}

	public void setSuptMonth(Integer suptMonth) {
		this.suptMonth = suptMonth;
	}

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
