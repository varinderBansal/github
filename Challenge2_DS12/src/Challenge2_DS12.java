import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Entities.parentCoupon;
import Entities.paymentSource;
import Entities.userCoupon;
import Entities.userData;
import Entities.userPayment;


public class Challenge2_DS12 {


	
	
	public static void main(String args[]) {
		
		HashMap<Long, userData> userDataMap=new HashMap<Long, userData>();
		ArrayList<userCoupon> couponList =new ArrayList<userCoupon>();
		HashMap<Integer, parentCoupon> parentCouponMap= new HashMap<Integer, parentCoupon>();
		HashMap<Integer, paymentSource> payUPayment = new HashMap<Integer, paymentSource>();
		HashMap<Integer, paymentSource> discountedPayment = new HashMap<Integer, paymentSource>();
		HashMap<Integer, userPayment> userPaymentMap = new HashMap<Integer, userPayment>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String csvFile = "dataFiles/userData.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
	 
		try {
			///////////user data////////
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(cvsSplitBy);
				userDataMap.put(Long.valueOf(userData[1]), new userData(Long.valueOf(userData[1]),Integer.valueOf(userData[2])));
			}
			///////user coupon///////
			csvFile = "dataFiles/userCopoun.csv";
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(cvsSplitBy);
				if(userData[2].trim().equalsIgnoreCase(""))
					couponList.add(new userCoupon(Long.valueOf(userData[3]),0,Integer.parseInt(userData[1])));
				else
					couponList.add(new userCoupon(Long.valueOf(userData[3]),Integer.valueOf(userData[2]),Integer.parseInt(userData[1])));
			}
			///////////////parent coupon////////////
			csvFile = "dataFiles/parentCoupon.csv";
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(cvsSplitBy);
				parentCouponMap.put(Integer.valueOf(userData[1]), new parentCoupon(Integer.valueOf(userData[1]),Integer.valueOf(userData[2]),Integer.valueOf(userData[3]),Integer.valueOf(userData[4]),Integer.valueOf(userData[5])));
			}
			
			///////////////payment source////////////
			csvFile = "dataFiles/paymentSource.csv";
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(cvsSplitBy);
				if(userData[3].equalsIgnoreCase("DISCOUNT"))
					discountedPayment.put(Integer.valueOf(userData[1]), new paymentSource(Integer.valueOf(userData[1]),Integer.valueOf(userData[2])));
				else
					payUPayment.put(Integer.valueOf(userData[1]), new paymentSource(Integer.valueOf(userData[1]),Integer.valueOf(userData[2])));
			
			}
			
			///////////////user payment////////////
			csvFile = "dataFiles/userPayment.csv";
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(cvsSplitBy);
				userPaymentMap.put(Integer.valueOf(userData[1]), new userPayment(Integer.valueOf(userData[1]),Long.valueOf(userData[6]),df.parse(userData[2]),userData[3],df.parse(userData[4]),Integer.valueOf(userData[5])));
			}
			
			
			//////// Categories users --- Algo///////
			/*
			 * Category 1 new users - user have only registered or max 2 transaction or less then 5 refers 
			 * 
			 * Category 2 Coupon using user -- min 2 TXN with >75% of them using coupons 
			 * 
			 * category 3 Refering users  --- min 10 refers with > 50 sucess
			 * 
			 * category 4 ideal user --  min 5 txn with each less then 2 month apart or 10 in a year uses payU on all value ranged txns.
			 * 
			 * 
			 * 
			 * 
			 */
			
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}
}
}
