package com.poc.ccd.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.ccd.dto.CustomerModel;
import com.poc.ccd.model.CardEntity;
import com.poc.ccd.model.Customer;
import com.poc.ccd.model.TransactionEntity;


@Repository
public class AccountServiceRepo {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	CardEntity card;
	
	@Autowired
	Customer custom;
	
	@Autowired
	TransactionEntity transactionEntity;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public CardEntity cardIssuer(CustomerModel customer) {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		String username=customer.getUser_name();
		int acno=0;
		int ccno=0;
		double totalLimit=0.0;
		//Criteria crit=session.createCriteria("Customer");
		List<CustomerModel> customerList = (List<CustomerModel>)session.createQuery("from customer where user_name='"+username+"'").list();
		if(customerList.size()>0) {
			
			acno=customerList.get(0).getAccno();
			ccno=customerList.get(0).getCcno();
			totalLimit=customerList.get(0).getAnnualIncome();
			LocalDate issueDt=LocalDate.now();
			LocalDate expDt=issueDt.plusYears(4);
			
			int day=issueDt.getDayOfMonth();
			int month=issueDt.getMonthValue();
			int year=issueDt.getYear();
			String txdt=String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year);
			
			int day2=expDt.getDayOfMonth();
			int month2=expDt.getMonthValue();
			int year2=expDt.getYear();
			String txdt2=String.valueOf(day2)+"-"+String.valueOf(month2)+"-"+String.valueOf(year2);
			
			Random rand = new Random(); 
			int cvv=rand.nextInt(1000);
			int pin=rand.nextInt(10000);
			totalLimit=totalLimit/12.0;
			card.setAcno(acno);
			card.setCcno(ccno);
			card.setCvv(cvv);
			card.setPin(pin);
			card.setExpDt(String.valueOf(txdt2));
			card.setIssueDt(String.valueOf(txdt));
			card.setTotalLimit(totalLimit);
			session.persist(card);
		}
		
		session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return card;
		
	}
	
	
	public void createCustom(CustomerModel customer) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<CustomerModel> customerList = (List<CustomerModel>)session.createQuery("from customer ").list();
			String accountno="120000000001";
			String ccno="1600000000000001";
			if(customerList.size()>0) {
				accountno=String.valueOf(customerList.get(customerList.size()-1).getAccno()+1);
				ccno=String.valueOf(customerList.get(customerList.size()-1).getCcno()+1);
			}
			
			custom.setUser_name(customer.getUser_name());
			custom.setDob(customer.getDob());
			custom.setPhno(customer.getPhno());
			custom.setMailid(customer.getMailId());
			custom.setAcno(Integer.parseInt(accountno));
			custom.setCcno(Integer.parseInt(ccno));
			custom.setAddr1(customer.getAddress1());
			custom.setAddr2(customer.getAddress2());
			custom.setPin(customer.getPin());
			custom.setDist(customer.getDist());
			custom.setState(customer.getState());
			custom.setAnnualIncome(customer.getAnnualIncome());	
			session.persist(custom);			
		
			session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public String transactionDetls(String username,int ccno,String expdt,int cvv,int pin,double amount) {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		
		double totalLimit=0.0;
		double nextLimit=0.0;
		//Criteria crit=session.createCriteria("Customer");
		List<CardEntity> cardList = (List<CardEntity>)session.createQuery("from customer where credit_card_details='"+ccno+"'").list();
		if(cardList.size()>0) {
			CardEntity carDetails=cardList.get(0);
			if(carDetails.getCvv()==cvv && (card.getExpDt()).equalsIgnoreCase(expdt) && card.getPin()==pin) {
				totalLimit=card.getTotalLimit();
				if(totalLimit<amount) {
					nextLimit=totalLimit-amount;				
				}		
			
				LocalDate today=LocalDate.now();
				int day=today.getDayOfMonth();
				int month=today.getMonthValue();
				int year=today.getYear();
				String txdt=String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year);
				
				transactionEntity.setAcno(card.getAcno());
				transactionEntity.setCcno(ccno);
				transactionEntity.setRemainingAmount(nextLimit);
				transactionEntity.setTransaction_amount(amount);
				transactionEntity.setTransaction_dt(txdt);
				session.persist(transactionEntity);	
			}
			
		}else {
			return "Error";
		}
				
		session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "Success";
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<TransactionEntity> genSlip(String username,int ccno,String stdt,String enddt) {
		ArrayList<TransactionEntity> cardList=null;
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		//Criteria crit=session.createCriteria("Customer");
		cardList = (ArrayList<TransactionEntity>)session.createQuery("from transaction_details where ccno = '"+ccno+"' and transaction_dt>='"+stdt+"' and transaction_dt<='"+enddt+"'").list();
		session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cardList;
	}
}
