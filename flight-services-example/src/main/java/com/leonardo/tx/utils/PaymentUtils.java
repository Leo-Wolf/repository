package com.leonardo.tx.utils;

import java.util.HashMap;
import java.util.Map;

import com.leonardo.tx.exception.InsuficientAmountException;

public class PaymentUtils {
	private static Map<String , Double> paymentMap = new HashMap<>();
	static{
		paymentMap.put("acc1",12000.0 );
		paymentMap.put("acc2",1000.0 );
		paymentMap.put("acc3",5000.0 );
		paymentMap.put("acc4",8000.0 );		
	}
	
	public static boolean validateCreditLimit(String accNo, double paidAmont) {
		if(paidAmont>paymentMap.get(accNo)) {
			throw new InsuficientAmountException("Insuficient found ... ! ");
		}else {
			return true;
		}
			
			
	}

}
