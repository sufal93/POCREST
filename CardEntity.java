package com.poc.ccd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cerdit_card_details")
public class CardEntity {
	@Id
	private int acno;
	@Id
	private int ccno;
	
	private int cvv;
	private int pin;
	private String issueDt;
	private String expDt;
	private Double totalLimit;
	
	
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	
	public int getCcno() {
		return ccno;
	}
	public void setCcno(int ccno) {
		this.ccno = ccno;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getIssueDt() {
		return issueDt;
	}
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	public String getExpDt() {
		return expDt;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	public Double getTotalLimit() {
		return totalLimit;
	}
	public void setTotalLimit(Double totalLimit) {
		this.totalLimit = totalLimit;
	}
	

}
