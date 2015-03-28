package Entities;

import java.util.Date;


public class userPayment {

	Long userID;
	Integer paymentID;
	Date addedON;
	Integer statusID;
	Date suceededOn;
	Integer totalAmount;
	
	public userPayment() {
		// TODO Auto-generated constructor stub
	}
	
	public userPayment(Integer paymentID,Long userID,Date addedOn,String status,Date suceededOn, Integer totalAmount) {
		this.paymentID=paymentID;
		this.userID=userID;
		addedON=addedOn;
		this.suceededOn=suceededOn;
		this.totalAmount=totalAmount;
	}
	
}
