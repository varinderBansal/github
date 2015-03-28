package Entities;

public class userCoupon {

	Long userID;
	Integer	paymentId;
	Integer couponID;
	
	public userCoupon() {
		// TODO Auto-generated constructor stub
	}
	
	public userCoupon(Long userID,Integer paymentID,Integer couponID) {
		this.couponID=couponID;
		this.userID=userID;
		paymentId=paymentID;
	}
	
}
