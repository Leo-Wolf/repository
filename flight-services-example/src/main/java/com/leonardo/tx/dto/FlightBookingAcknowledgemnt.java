package com.leonardo.tx.dto;

import com.leonardo.tx.entity.PassengerInfo;
import com.leonardo.tx.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgemnt {
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
