package com.kko.dto;

public class InstituteDto {

	private String institueCode;	//금융기관 코드
	
	private String instituteName;	//금융기관명

	public String getInstitueCode() {
		return institueCode;
	}

	public void setInstitueCode(String institueCode) {
		this.institueCode = institueCode;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	@Override
	public String toString() {
		return "InstituteDto [institueCode=" + institueCode + ", instituteName=" + instituteName + "]";
	}
	
}
