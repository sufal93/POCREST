package com.poc.ccd.dto;


public class Card {
	
	private int acno;
	private int ccno;
	private int cvv;
	private int pin;
	private String issueDt;
	private String expDt;
	private double totalLimit;
	
	public Card() {}

	
	
	public Card(int acno, int ccno, int cvv, int pin, String issueDt, String expDt, double totalLimit) {
		super();
		this.acno = acno;
		this.ccno = ccno;
		this.cvv = cvv;
		this.pin = pin;
		this.issueDt = issueDt;
		this.expDt = expDt;
		this.totalLimit = totalLimit;
	}



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

	public double getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(double totalLimit) {
		this.totalLimit = totalLimit;
	}
	

}
