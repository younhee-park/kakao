package com.kko.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class HouseMoneyYearDto {
	private String name = "주택금융 공급현황";
	
	@JsonProperty(" ")
	private List<HouseMoneyDto> houseMoneys;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HouseMoneyDto> getHouseMoneys() {
		return houseMoneys;
	}

	public void setHouseMoneys(List<HouseMoneyDto> houseMoneys) {
		this.houseMoneys = houseMoneys;
	}

	@Override
	public String toString() {
		return "HouseMoneyYearDto [name=" + name + ", houseMoneys=" + houseMoneys + "]";
	}
	
}
