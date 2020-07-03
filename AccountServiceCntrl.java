package com.poc.ccd.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.ccd.dto.CustomerModel;
import com.poc.ccd.model.CardEntity;
import com.poc.ccd.model.TransactionEntity;
import com.poc.ccd.service.IssueCreditCardService;
import com.poc.ccd.utility.Validation;

@Controller
public class AccountServiceCntrl {
	
	@Autowired
	IssueCreditCardService issueCreditCardService;
	@Autowired
	Validation validation;
	
	@RequestMapping(value="/issueCard",method=RequestMethod.GET)
	public @ResponseBody CardEntity issueCard(@RequestBody CustomerModel customerModel) {		
		
		CardEntity card=null;
		try {
			
			if(validation.validateUser(customerModel.getUser_name()) && validation.validatePhno(customerModel.getPhno()) &&
					validation.validateDOB(customerModel.getDob()) && 
					validation.validateMail(customerModel.getMailId())) {				
				card=issueCreditCardService.cardIssuer(customerModel);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return card;
		
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public @ResponseBody CardEntity createAccount(@RequestBody CustomerModel cutomModel) {		
			
		CardEntity res=null;
		CardEntity result=null;
		try {
			
			if(validation.validateUser(cutomModel.getUser_name()) &&
					validation.validateDOB(cutomModel.getDob()) && 
					validation.validateMail(cutomModel.getMailId()) && validation.validatePin(cutomModel.getPhno())) {	
				issueCreditCardService.createCustom(cutomModel);	
				res=issueCreditCardService.cardIssuer(cutomModel);
				result.setAcno(res.getAcno());
				result.setCcno(res.getCcno());
				result.setExpDt(res.getExpDt());
				result.setCvv(res.getCvv());
				result.setTotalLimit(res.getTotalLimit());
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	@RequestMapping(value="/doTransaction/{username}/{ccno}/{expdt}/{cvv}/{pin}/{amount}",method=RequestMethod.GET)
	public String transactionAmount(@PathVariable ("username")String  username,@PathVariable("ccno") int ccno,
			@PathVariable("expdt") String expdt,@PathVariable("cvv") int cvv,@PathVariable("pin") int pin,
			@PathVariable("amount") double amount) {		
		
		String res=null;
		try {
			
			if(validation.validateUser(username) &&
					validation.validateCCNo(ccno) && 
					validation.validateCvv(cvv) && validation.validatePin(pin)) {	
				
				
				res=issueCreditCardService.transactionDetails(username,ccno,expdt,cvv,pin,amount);	
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
		
	}
	
	@RequestMapping(value="/genStatement/{username}/{ccno}/{stdt}/{enddt}",method=RequestMethod.GET)
	public ArrayList<TransactionEntity> generateState(@PathVariable ("username")String  username,@PathVariable("ccno") int ccno,
			@PathVariable("stdt") String stdt,@PathVariable("enddt") String enddt) {		
		
		ArrayList<TransactionEntity> res=null;
		try {
			
			if(validation.validateUser(username) &&
					validation.validateCCNo(ccno)) {	
				res=issueCreditCardService.genetransactionSlip(username,ccno,stdt,enddt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
		
	}
}
