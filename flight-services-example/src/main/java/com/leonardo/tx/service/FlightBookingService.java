package com.leonardo.tx.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.tx.dto.FlightBookingAcknowledgemnt;
import com.leonardo.tx.dto.FlightBookingRequest;
import com.leonardo.tx.entity.PassengerInfo;
import com.leonardo.tx.entity.PaymentInfo;
import com.leonardo.tx.repository.PassengerInfoRepository;
import com.leonardo.tx.repository.PaymentInfoRepository;
import com.leonardo.tx.utils.PaymentUtils;

@Service
public class FlightBookingService {
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	@Transactional
	public FlightBookingAcknowledgemnt bookFlightTickets(FlightBookingRequest request) {
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPid());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgemnt("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
		
	}

}
