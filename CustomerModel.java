package com.poc.ccd.dto;

public class CustomerModel {
	private String user_name;
	private String dob;
	private int phno;
	private String mailId;
	private double annualIncome;
	private String address1;
	private String address2;
	private int accno;
	private int ccno;
	private String dist;
	private String state;
	private int pin;
	
	public CustomerModel() {}
	
	
	
	public CustomerModel(String user_name, String dob, int phno, String mailId, double annualIncome) {
		super();
		this.user_name = user_name;
		this.dob = dob;
		this.phno = phno;
		this.mailId = mailId;
		this.annualIncome = annualIncome;
	}
	
	
	public CustomerModel(String user_name, String dob, int phno, String mailId, double annualIncome, String address1,
			String address2, int accno, int ccno, String dist, String state, int pin) {
		super();
		this.user_name = user_name;
		this.dob = dob;
		this.phno = phno;
		this.mailId = mailId;
		this.annualIncome = annualIncome;
		this.address1 = address1;
		this.address2 = address2;
		this.accno = accno;
		this.ccno = ccno;
		this.dist = dist;
		this.state = state;
		this.pin = pin;
	}



	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public int getAccno() {
		return accno;
	}



	public void setAccno(int accno) {
		this.accno = accno;
	}



	public int getCcno() {
		return ccno;
	}



	public void setCcno(int ccno) {
		this.ccno = ccno;
	}



	public String getDist() {
		return dist;
	}



	public void setDist(String dist) {
		this.dist = dist;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getPin() {
		return pin;
	}



	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
}
