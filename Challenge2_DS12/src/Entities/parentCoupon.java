package Entities;

public class parentCoupon {

	Integer couponID;
	Integer couponType;
	Integer maxOffer;
	Integer minOffer;
	Integer minTxn;
	
	public parentCoupon() {
		// TODO Auto-generated constructor stub
	}
	
	public parentCoupon(Integer couponId,Integer couponType,Integer maxOffer,Integer minOffer, Integer minTxn) {
		couponID=couponId;
		this.couponType=couponType;
		this.maxOffer=maxOffer;
		this.minTxn=minTxn;
		this.minOffer=minOffer;
	
	}
	
	
}
