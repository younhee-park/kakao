//package com.kko.domain.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.google.common.collect.Lists;
//
//@Entity
//@Table(name="TB_HOUSE_STST")
//@IdClass(HouseMoneyStstEntityPK.class)
//public class HouseMoneyStstEntity {
//
//	@Id
//	@Column(name = "supt_year", nullable = false)
//	private Integer suptYear;
//	
//	@Id
//	@Column(name = "institute_code", nullable = false, length=3)
//	private String instituteCode;
//	
////	TODO default값 확인
//	@Column(name = "tot_amount", nullable = true)
//	private Integer totAmount;
//	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumns({
//	    @JoinColumn(name="supt_year", referencedColumnName = "supt_year"),
//	    @JoinColumn(name="institute_code", referencedColumnName = "institute_code")
//	})
//	private List<HouseMoneyEntity> HouseMoneyDetailEntitys = Lists.newArrayList();
//
//	public Integer getSuptYear() {
//		return suptYear;
//	}
//
//	public void setSuptYear(Integer suptYear) {
//		this.suptYear = suptYear;
//	}
//
//	public String getInstituteCode() {
//		return instituteCode;
//	}
//
//	public void setInstituteCode(String instituteCode) {
//		this.instituteCode = instituteCode;
//	}
//
//	public Integer getTotAmount() {
//		return totAmount;
//	}
//
//	public void setTotAmount(Integer totAmount) {
//		this.totAmount = totAmount;
//	}
//
//	public List<HouseMoneyEntity> getHouseMoneyDetailEntitys() {
//		return HouseMoneyDetailEntitys;
//	}
//
//	public void setHouseMoneyDetailEntitys(List<HouseMoneyEntity> houseMoneyDetailEntitys) {
//		HouseMoneyDetailEntitys = houseMoneyDetailEntitys;
//	}
//
//	@Override
//	public String toString() {
//		return "HouseMoneyEntity [suptYear=" + suptYear + ", instituteCode=" + instituteCode + ", totAmount="
//				+ totAmount + ", HouseMoneyDetailEntitys=" + HouseMoneyDetailEntitys + "]";
//	}
//	
//	
//	
//}
//
//class HouseMoneyStstEntityPK implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 3142865966520440670L;
//
//	private String suptYear;
//	private String instituteCode;
//	
//	
//	public String getSuptYear() {
//		return suptYear;
//	}
//	public void setSuptYear(String suptYear) {
//		this.suptYear = suptYear;
//	}
//	public String getInstituteCode() {
//		return instituteCode;
//	}
//	public void setInstituteCode(String instituteCode) {
//		this.instituteCode = instituteCode;
//	}
//	
//}
