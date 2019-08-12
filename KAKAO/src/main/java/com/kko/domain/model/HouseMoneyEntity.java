package com.kko.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="TB_HOUSE")
@IdClass(HouseMoneyEntityPK.class)
public class HouseMoneyEntity {

	@Id
	@Column(name = "supt_year", nullable = false)
	String suptYear;
	
	@Id
	@Column(name = "supt_month", nullable = false)
	Integer suptMonth;

//TODO length	
	@Id
	@Column(name = "institute_code", nullable = false, length=10)
	String instituteCode;
	
	@Column(name = "amount", nullable = true)
	Integer amount;

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

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "HouseMoneyDetailEntity [suptYear=" + suptYear + ", suptMonth=" + suptMonth + ", instituteCode="
				+ instituteCode + ", amount=" + amount + "]";
	}
	
	
}

class HouseMoneyEntityPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3781438058119021637L;
	
	private String suptYear;
	private Integer suptMonth;
	private String instituteCode;
	
	
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
	public String getInstituteCode() {
		return instituteCode;
	}
	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}
	
}
