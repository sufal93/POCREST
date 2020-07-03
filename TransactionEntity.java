package com.poc.ccd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionEntity {
	@Id
	private int acno;
	@Id
	private int ccno;
	private double transaction_amount;
	private String transaction_dt;
	private double remainingAmount;
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
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getTransaction_dt() {
		return transaction_dt;
	}
	public void setTransaction_dt(String transaction_dt) {
		this.transaction_dt = transaction_dt;
	}
	public double getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	
	

}
