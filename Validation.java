package com.poc.ccd.utility;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {

		public boolean validateUser(String uname) {
			Pattern pattern=Pattern.compile("[A-Za-z0-9]");
			Matcher matchUser=pattern.matcher(String.valueOf(uname));			
			return matchUser.matches();
		}
		public boolean validatePhno(int phno) {
			Pattern pattern=Pattern.compile("\\d{10}");
			Matcher matchMobile=pattern.matcher(String.valueOf(phno));			
			return matchMobile.matches();
		}
		public boolean validateDOB(String dob) {
			
			if(getage(dob)<18) {
				return false;
			}
			Pattern pattern=Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
			Matcher matchDob=pattern.matcher(dob);
			return matchDob.matches();
			
		}
		public boolean validateMail(String mail) {
			
			Pattern pattern=Pattern.compile("[A-Za-z0-9@.]");
			Matcher matchMail=pattern.matcher(mail);			
			return matchMail.matches();
		}
		public boolean validateCCNo(int ccno) {
			Pattern pattern=Pattern.compile("\\d{16}");
			Matcher matchCCno=pattern.matcher(String.valueOf(ccno));			
			return matchCCno.matches();
		}
		public boolean validateCvv(int cvv) {
			Pattern pattern=Pattern.compile("\\d{3}");
			Matcher matchCvv=pattern.matcher(String.valueOf(cvv));			
			return matchCvv.matches();
		}
		public boolean validatePin(int pin) {
			Pattern pattern=Pattern.compile("\\d{4}");
			Matcher matchPin=pattern.matcher(String.valueOf(pin));			
			return matchPin.matches();
		}
		public int getage(String dob) {
			String[] words=dob.split("-");
			int month[] = { 31, 28, 31, 30, 31, 30, 31,  
                    31, 30, 31, 30, 31 }; 
			 int birth_date = Integer.parseInt(words[0]);
		     int birth_month = Integer.parseInt(words[1]);
		     int birth_year = Integer.parseInt(words[2]);
		     LocalDate today=LocalDate.now();
		     int currentYear=today.getYear();
		     int currentMonth=today.getMonthValue();
		     int curDt=today.getDayOfMonth();
		     
		     if(birth_date>curDt) {
		    	 currentMonth--;
		    	 curDt+=month[birth_month-1];
		     }
		     if(birth_month>currentMonth) {
		    	 currentYear--;
		    	 currentMonth+=12;
		     }
		     
		     int calYr=currentYear-birth_year;
		     return calYr;
			
		}
}
