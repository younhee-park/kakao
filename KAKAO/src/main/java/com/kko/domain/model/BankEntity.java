package com.kko.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_BANK_CD")
public class BankEntity {

	@Id
	@Column(name = "institute_code", nullable = false, length=10)
	String instituteCode;
	
	@Column(name = "institute_name", nullable = false, length=30)
	String instituteName;

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

	@Override
	public String toString() {
		return "BankEntity [instituteCode=" + instituteCode + ", instituteName=" + instituteName + "]";
	}
	
}