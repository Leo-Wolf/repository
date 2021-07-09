package com.leonardo.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.tx.dto.FlightBookingAcknowledgemnt;
import com.leonardo.tx.dto.FlightBookingRequest;
import com.leonardo.tx.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServicesExampleApplication {

	@Autowired
	private FlightBookingService service;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgemnt bookFlightTicktes(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTickets(request);
	}
	public static void main(String[] args) {
		SpringApplication.run(FlightServicesExampleApplication.class, args);
	}

}
