package com.poc.ccd.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ccd.dao.AccountServiceRepo;
import com.poc.ccd.dto.Card;
import com.poc.ccd.dto.CustomerModel;
import com.poc.ccd.model.CardEntity;
import com.poc.ccd.model.TransactionEntity;

@Service
public class IssueCreditCardService {
	
	@Autowired
	AccountServiceRepo accountServiceRepo;
	
	@Transactional
	public CardEntity cardIssuer(CustomerModel customer) {
		CardEntity card=accountServiceRepo.cardIssuer(customer);
		return card;
	}
	
	@Transactional
	public String transactionDetails(String username,int ccno,String expdt,int cvv,int pin,double amount) {
		String res=accountServiceRepo.transactionDetls(username,ccno,expdt,cvv,pin,amount);
		return res;
	}
	
	
	@Transactional
	public void createCustom(CustomerModel customer) {
		accountServiceRepo.createCustom(customer);		
	}
	@Transactional
	public ArrayList<TransactionEntity> genetransactionSlip(String username,int ccno,String stdt,String enddt){
		ArrayList<TransactionEntity> res=null;
		res=accountServiceRepo.genSlip(username,ccno,stdt,enddt);
		return res;
	}
	
	
	

}
